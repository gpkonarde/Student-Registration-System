class Course {
    String courseId;
    String courseName;
    String instructor;
    String stdId;

    Course(String courseId, String courseName, String instructor, String stdId){
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.stdId = stdId;
    }

    @Override
    public String toString(){
        return "*** Course Details *** \n" + "\n Course Name : "+ this.courseName + "\n Course ID : " + this.courseId + "\n Course Instructor : " + this.instructor + "\n Student Enrolled : " +this.stdId; 
    }
}

class Student {
    String stdId;
    String stdName;
    int age;
    String email;

    Student(String stdId, String stdName, int age, String email){
        this.stdId = stdId;
        this.stdName = stdName;
        this.age = age;
        this.email = email;
    }
    
    @Override
    public String toString(){
        return "*** Student Details *** \n" + "\n Student Name : "+ this.stdName + "\n Studebt ID : " + this.stdId + "\n Student Age : " + this.age + "\n Student Email : " +this.email; 
    }
}


public class Registration {
    double fees;
    String consultant;
    Student std;
    Course course;
    Registration(double fees, String consultant , Student std , Course course){
        this.fees = fees;
        this.consultant = consultant;
        this.std = std;
        this.course = course;
    }

    public void displayRegi(){
        System.out.println("*** Registration Details *** \n");
        System.out.println( "Consultant Name : "+this.consultant);
        System.out.println( " Fees : "+this.fees);
        System.out.println(std);
        System.out.println(course);

    }

    public static void main(String[] args) {
        Student std = new Student("S-007", "Gajanan Konarde", 22, "gajananpkonarde@gmail.com");
        Course course = new Course("J-020", "Java Fullstack", "Shirkant", "S-007");
        Registration obj = new Registration(1000, "Hitesh Reshmiya", std, course); 

        obj.displayRegi();
    }
}
