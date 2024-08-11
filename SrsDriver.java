import java.util.Scanner;

public class SrsDriver {
    public static void main(String[] args) {

        Student student = null;
        Course course;

        System.out.println("*** Welcome to Zingur Consultancy ***");
        System.out.println("1. Enroll as Student");
        System.out.println("2. Enter Course information");
        System.out.println("3. Remove Student");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        for(;;){
            int input = sc.nextInt();

            switch (input) {
                case 1:
                sc.nextLine();
                System.out.print("Enter Student Name : ");
                String stdName = sc.nextLine();
                System.out.print("Enter Student Age : ");
                int sAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Student Email : ");
                String sEmail = sc.nextLine();
                System.out.println("Enter Course ID : ");
                int courId = sc.nextInt();
                sc.nextLine();
                
                student = new Student(stdName, sAge, sEmail,courId);
                SrsDb.addStudent(student);
                System.out.println("Student Entered Succesfully");

                break;
                case 2: 
                sc.nextLine();
                System.out.println("Enter Instructors name: ");
                String instr = sc.nextLine();
                System.out.println("Enter Course Name : ");
                String cr = sc.nextLine();

                course = new Course(cr, instr);
                SrsDb.addCourse(course);
                System.out.println("Course added succesfully");
                break;
                case 3: System.out.println("Remove Student"); break;
                case 4: System.exit(0); break;
                default:System.out.println("Invalid Input!");break;
            }
        }

    }    
}
