import java.sql.*;

public class SrsDb {

    static String url = "jdbc:mysql://localhost:3306/srs";
    static String username = "root";
    static String password = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, username, password);
                    Statement stmt = con.createStatement()) {

                // Create table courses
                createCourse(stmt);
                // Create table students
                createStudent(stmt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Db handling methods

    public static void createEnrollment(Statement stmt) {
        try {
            String create = "CREATE TABLE IF NOT EXISTS Enrollment (" +
                    "sId INT, " +
                    "cId INT, " +
                    "enrollmentDate DATE NOT NULL, " +
                    "PRIMARY KEY (sId, cId), " +
                    "FOREIGN KEY (sId) REFERENCES Student(sId) ON DELETE CASCADE, " +
                    "FOREIGN KEY (cId) REFERENCES Course(cId) ON DELETE CASCADE" +
                    ");";
            stmt.execute(create);
            System.out.println("Enrollment table created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createCourseInstructor(Statement stmt) {
        try {
            String create = "CREATE TABLE IF NOT EXISTS CourseInstructor (" +
                    "cId INT, " +
                    "iId INT, " +
                    "PRIMARY KEY (cId, iId), " +
                    "FOREIGN KEY (cId) REFERENCES Course(cId) ON DELETE CASCADE, " +
                    "FOREIGN KEY (iId) REFERENCES Instructor(iId) ON DELETE CASCADE" +
                    ");";
            stmt.execute(create);
            System.out.println("CourseInstructor table created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void creatInstructor(Statement stmt) {
        try {
            String create = "CREATE TABLE IF NOT EXISTS Instructor (" +
                    "iId INT AUTO_INCREMENT PRIMARY KEY, " +
                    "iName VARCHAR(50) NOT NULL, " +
                    "iEmail VARCHAR(100) NOT NULL, " +
                    "UNIQUE(iEmail)" +
                    ");";
            stmt.execute(create);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createCourse(Statement stmt) {
        try {
            String create = "CREATE TABLE IF NOT EXISTS Course (" +
                    "cId INT AUTO_INCREMENT PRIMARY KEY, " +
                    "cName VARCHAR(50) NOT NULL, " +
                    "UNIQUE(cName)" +
                    ");";
            stmt.execute(create);
            System.out.println("Course table created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createStudent(Statement stmt) {
        try {
            String create = "CREATE TABLE IF NOT EXISTS Student (" +
                    "sId INT AUTO_INCREMENT PRIMARY KEY, " +
                    "sName VARCHAR(20) NOT NULL, " +
                    "sAge INT NOT NULL, " +
                    "sEmail VARCHAR(20) NOT NULL, " +
                    "cId INT, " +
                    "FOREIGN KEY (cId) REFERENCES Course(cId)" +
                    ")";
            stmt.execute(create);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCourse(Course course) {
        String insert = "INSERT INTO Course (cName) VALUES (?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = con.prepareStatement(insert)) {

            pstmt.setString(1, course.getCourseName());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Student student) {
        String insert = "INSERT INTO Student (sName, sAge, sEmail, cId) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = con.prepareStatement(insert)) {

            pstmt.setString(1, student.getStdName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getEmail());
            pstmt.setInt(4, student.getCourseId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addInstructor(Instructor instructor) {
        String insert = "INSERT into instructor (iName , iEmail) Values (? , ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = con.prepareStatement(insert)) {

            pstmt.setString(1, instructor.getInstructorName());
            pstmt.setString(2, instructor.getInstructorEmail());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enrollStudent(EnrollmentManager manager, int studentId, int courseId, int instructorId) {
        String insert = "Insert into Enrollment (sId, cId, enrollmentDate) Values(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = con.prepareStatement(insert)) {

            pstmt.setInt(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.setString(3, manager.getEnrollmentDate());
            pstmt.executeUpdate();
            System.out.println("Enrolling student with ID: " + studentId + ", course ID: " + courseId
                    + ", enrollment date: " + manager.getEnrollmentDate());
            System.out.println("Student enrolled");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
