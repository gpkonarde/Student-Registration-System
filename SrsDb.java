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

    public static void createCourse(Statement stmt) {
        try {
            String create = "CREATE TABLE IF NOT EXISTS Course (" +
                            "cId INT AUTO_INCREMENT PRIMARY KEY, " +
                            "cName VARCHAR(20) NOT NULL, " +
                            "Instructor VARCHAR(50) NOT NULL" +
                            ")";
            stmt.execute(create);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Db handling methods
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
        String insert = "INSERT INTO Course (cName, Instructor) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(insert)) {

            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getInstructor());

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
}
