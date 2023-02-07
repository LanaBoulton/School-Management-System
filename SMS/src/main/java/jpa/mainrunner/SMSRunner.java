package jpa.mainrunner;

/**
 *
 *
 * THIS WAS IN SBA ASSIGNMENT,
 * just slightly modified

 *
 */

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;


public class SMSRunner {

    private Scanner sin;
    private StringBuilder sb;
    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;


    public SMSRunner() {
        sin = new Scanner(System.in);
        sb = new StringBuilder();
        courseService = new CourseService();
        studentService = new StudentService();
    }

    public static void main(String[] args) {

        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    private void run() {
        // Login or quit
        switch (menu1()) {
            case 1:
                if (studentLogin()) {
                    registerMenu();
                }
                break;
            case 2:
                out.println("Goodbye!");
                break;

            default:

        }
    }

    private int menu1() {
        sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
        out.print(sb.toString());
        sb.delete(0, sb.length());

        return sin.nextInt();
    }

    private boolean studentLogin() {
        boolean retValue = false;
        out.print("Enter your email address: ");
        String email = sin.next();
        out.print("Enter your password: ");
        String password = sin.next();

        if (studentService.validateStudent(email, password)) {
            currentStudent = studentService.getStudentByEmail(email);
            List<Course> courses = studentService.getStudentCourses(currentStudent);
            out.println("MyClasses");
            for (Course course : courses) {
                out.println(course);
            }
            retValue = true;
        } else {
            out.println("User Validation failed. GoodBye!");
        }
        return retValue;
    }

    private void registerMenu() {
        sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
        out.print(sb.toString());
        sb.delete(0, sb.length());

        switch (sin.nextInt()) {
            case 1:
                List<Course> allCourses = courseService.getAllCourses();
                List<Course> studentCourses = studentService.getStudentCourses(currentStudent);
                allCourses.removeAll(studentCourses);
                out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
                for (Course course : allCourses) {
                    out.println(course);
                }
                out.println();
                out.print("Enter Course Number: ");
                int number = sin.nextInt();
                Course newCourse = courseService.GetCourseById(number);

                if (newCourse != null) {
                    studentService.registerStudentToCourse(currentStudent, newCourse);
                    Student temp = studentService.getStudentByEmail(currentStudent.getstudentEmail());

                    out.println("MyClasses");
                    for (Course course : temp.getstudentCourses()) {
                        out.println(course);
                    }
                }
                break;
            case 2:
            default:
                out.println("Goodbye!");
        }
    }
}