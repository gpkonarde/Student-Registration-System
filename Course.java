import java.util.*;

class Course {
    private int courseId;
    private String courseName;
    private String instructor;


    Course( String courseName, String instructor){
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public int getCourseId(){
        return courseId;
    }

    public void setCourseId(){
        this.courseId = courseId;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(){
        this.courseName = courseName;
    }
    public String getInstructor(){
        return instructor;
    }

    public void setInstructor(){
        this.instructor = instructor;
    }
}