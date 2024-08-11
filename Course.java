import java.util.*;

class Course {
    private int courseId;
    private String courseName;
    private String instructor;


    Course( String courseName, String instructor){
        setCourseName(courseName);
        setInstructor(instructor);
    }


    // Getters and Setters
    
    public int getCourseId(){
        return courseId;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getInstructor(){
        return instructor;
    }

    public void setInstructor(String instructor){
        this.instructor = instructor;
    }
}