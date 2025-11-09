package universityregistration;

import java.util.Scanner;

public class UniversityRegistration {
    public static void main(String[] args) {
        EnrollmentManager manager = new EnrollmentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== University Registration System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. List Courses by Student");
            System.out.println("5. List Students by Course");
            System.out.println("6. Remove Enrollment");
            System.out.println("7. Remove Student");
            System.out.println("8. Remove Course");
            System.out.println("9. Sort Students by ID");
            System.out.println("10. Sort Courses by ID");
            System.out.println("11. Last Student/Course Added");
            System.out.println("12. Check if Course is Full");
            System.out.println("13. Check if Student is Normal");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    manager.addStudent(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter Course ID: ");
                    manager.addCourse(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    int cid = sc.nextInt();
                    manager.enrollStudent(sid, cid);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    manager.listCoursesByStudent(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Course ID: ");
                    manager.listStudentsByCourse(sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    cid = sc.nextInt();
                    manager.removeEnrollment(sid, cid);
                    break;
                case 7:
                    System.out.print("Enter Student ID: ");
                    manager.removeStudent(sc.nextInt());
                    break;
                case 8:
                    System.out.print("Enter Course ID: ");
                    manager.removeCourse(sc.nextInt());
                    break;
                case 9:
                    manager.sortStudentsByID();
                    System.out.println("Students sorted by ID.");
                    break;
                case 10:
                    manager.sortCoursesByID();
                    System.out.println("Courses sorted by ID.");
                    break;
                case 11:
                    System.out.println("Last Student ID: " + manager.getLastStudentAdded());
                    System.out.println("Last Course ID: " + manager.getLastCourseAdded());
                    break;
                case 12:
                    System.out.print("Enter Course ID: ");
                    System.out.println(manager.isFullCourse(sc.nextInt()) ? "Course is full." : "Course is not full.");
                    break;
                case 13:
                    System.out.print("Enter Student ID: ");
                    System.out.println(manager.isNormalStudent(sc.nextInt()) ? "Student is normal." : "Student is not normal.");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
