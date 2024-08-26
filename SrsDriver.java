import java.util.ArrayList;
import java.util.Scanner;

public class SrsDriver {
    public static void main(String[] args) {

        Student student = null;
        Course course = null;
        Instructor inst = null;
        EnrollmentManager manager = null;

        System.out.println("*** Welcome to Zingur Consultancy ***");
        System.out.println("1. Enroll as Student");
        System.out.println("2. Enroll as Instructor");
        System.out.println("3. Add Course to Syllabus");
        System.out.println("4. Assign Instructor to course");
        System.out.println("5. Exit");
        Scanner sc = new Scanner(System.in);
        for (;;) {
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
                    System.out.print("Enter Course ID : ");
                    int courId = sc.nextInt();
                    sc.nextLine();

                    student = new Student(stdName, sAge, sEmail, courId);
                    SrsDb.addStudent(student);
                    System.out.println("Student Entered Succesfully");

                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Enter Instructors Name: ");
                    String iName = sc.nextLine();
                    System.out.print("Enter your Email: ");
                    String iEmail = sc.nextLine();

                    inst = new Instructor(iName, iEmail);
                    SrsDb.addInstructor(inst);
                    System.out.println("Instructor added succesfully");
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = sc.nextLine();
                    System.out.println("Course added succesfully ! Assign instructor to it");
                    course = new Course(courseName);
                    SrsDb.addCourse(course);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    ArrayList<Integer> courseIds = new ArrayList<>();
                    boolean addMoreCourses = true;

                    while (addMoreCourses) {
                        System.out.print("Enter Course ID: ");
                        int courseId = sc.nextInt();
                        sc.nextLine();
                        courseIds.add(courseId);

                        System.out.print("Do you want to add another course? (yes/no): ");
                        String response = sc.nextLine().toLowerCase();
                        if (!response.equals("yes")) {
                            addMoreCourses = false;
                        }
                    }

                    System.out.print("Enter enrollment Date (yyyy-mm-dd): ");
                    String enrollmentDate = sc.nextLine();

                    manager = new EnrollmentManager(enrollmentDate);

                    try {
                        manager.enrollStudent(studentId, courseIds);
                        System.out.println("Student enrolled successfully.");
                    } catch (Exception e) {
                        System.err.println("Failed to enroll student: " + e.getMessage());
                    }

                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    sc.close();
                    System.out.println("Invalid Input!");
                    break;
            }
        }

    }
}
