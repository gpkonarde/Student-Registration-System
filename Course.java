import java.util.*;

class Course {
    private int courseId;
    private String courseName;

    Course(String courseName) {
        setCourseName(courseName);
    }

    Course(int courseId) {
        setCourseId(courseId);
    }

    // Getters and Setters

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}