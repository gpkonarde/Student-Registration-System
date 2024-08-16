import java.sql.*;
import java.util.*;

public class EnrollmentManager {
    private static final String url = "jdbc:mysql://localhost:3306/srs";
    private static final String username = "root";
    private static final String password = "root";
    private String enrollmentDate;
    Course course;
    Student student;
    Instructor instructor;

    EnrollmentManager(String enrollmentDate) {
        setEnrollmentDate(enrollmentDate);
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void enrollStudent(int studentId, ArrayList<Integer> courseIds) throws Exception {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            int currentEnrollments = getStudentCurrentEnrollments(studentId, conn);
            if (currentEnrollments >= 3) {
                throw new Exception("A student can only enroll in up to 3 courses.");
            }

            ArrayList<Integer> instructorIds = new ArrayList<>();
            for (int courseId : courseIds) {
                findCourseInstructors(courseId, instructorIds, conn);
            }

            insertEnrollmentRecords(studentId, courseIds, instructorIds, conn);
        }
    }

    private int getStudentCurrentEnrollments(int studentId, Connection conn) throws Exception {
        String query = "SELECT COUNT(*) FROM Enrollment WHERE sId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    return 0; // No enrollments found
                }
            }
        }
    }

    private void findCourseInstructors(int courseId, ArrayList<Integer> instructorIds, Connection conn)
            throws Exception {
        String query = "SELECT iId FROM CourseInstructor WHERE cId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    instructorIds.add(rs.getInt(1));
                }
            }
        }
    }

    private void insertEnrollmentRecords(int studentId, ArrayList<Integer> courseIds, ArrayList<Integer> instructorIds,
            Connection conn) throws Exception {
        String query = "INSERT INTO Enrollment (sId, cId, enrollmentDate) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < courseIds.size(); i++) {
                stmt.setInt(1, studentId);
                stmt.setInt(2, courseIds.get(i));
                stmt.setString(3, enrollmentDate);
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
    }

    public static void enrollStudent(EnrollmentManager manager, int studentId, int courseId, int instructorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enrollStudent'");
    }
}
