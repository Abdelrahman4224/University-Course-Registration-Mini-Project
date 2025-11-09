package universityregistration;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class EnrollmentManager {
    LinkedList<Student> students;
    LinkedList<Course> courses;
    Student lastStudent;
    Course lastCourse;

    public EnrollmentManager() {
        students = new LinkedList<>();
        courses = new LinkedList<>();
    }

    // Add and remove students
    public void addStudent(int studentID) {
        Student student = new Student(studentID);
        students.add(student);
        lastStudent = student;
    }

    public void removeStudent(int studentID) {
        Student student = findStudent(studentID);
        if (student != null) {
            for (Course c : courses) {
                c.students.remove(student);
            }
            students.remove(student);
        }
    }

    // Add and remove courses
    public void addCourse(int courseID) {
        Course course = new Course(courseID);
        courses.add(course);
        lastCourse = course;
    }

    public void removeCourse(int courseID) {
        Course course = findCourse(courseID);
        if (course != null) {
            for (Student s : students) {
                s.courses.remove(course);
            }
            courses.remove(course);
        }
    }

    // Enrollment management
    public void enrollStudent(int studentID, int courseID) {
        Student student = findStudent(studentID);
        Course course = findCourse(courseID);
        if (student != null && course != null) {
            if (!student.courses.contains(course)) {
                student.courses.add(course);
                course.students.add(student);
            }
        }
    }

    public void removeEnrollment(int studentID, int courseID) {
        Student student = findStudent(studentID);
        Course course = findCourse(courseID);
        if (student != null && course != null) {
            student.courses.remove(course);
            course.students.remove(student);
        }
    }

    // Listing and sorting
    public void listCoursesByStudent(int studentID) {
        Student student = findStudent(studentID);
        if (student != null) {
            System.out.println("Courses for Student ID " + studentID + ":");
            for (Course c : student.courses) {
                System.out.println("- Course ID: " + c.id);
            }
        }
    }

    public void listStudentsByCourse(int courseID) {
        Course course = findCourse(courseID);
        if (course != null) {
            System.out.println("Students for Course ID " + courseID + ":");
            for (Student s : course.students) {
                System.out.println("- Student ID: " + s.id);
            }
        }
    }

    public void sortStudentsByID() {
        Collections.sort(students, Comparator.comparingInt(s -> s.id));
    }

    public void sortCoursesByID() {
        Collections.sort(courses, Comparator.comparingInt(c -> c.id));
    }

    // Checking conditions
    public boolean isFullCourse(int courseID) {
        Course course = findCourse(courseID);
        return course != null && course.students.size() >= 30;
    }

    public boolean isNormalStudent(int studentID) {
        Student student = findStudent(studentID);
        if (student != null) {
            int n = student.courses.size();
            return n >= 2 && n <= 7;
        }
        return false;
    }

    public int getLastStudentAdded() {
        return lastStudent != null ? lastStudent.id : -1;
    }

    public int getLastCourseAdded() {
        return lastCourse != null ? lastCourse.id : -1;
    }

    // Helper methods
    private Student findStudent(int studentID) {
        for (Student s : students) {
            if (s.id == studentID) return s;
        }
        return null;
    }

    private Course findCourse(int courseID) {
        for (Course c : courses) {
            if (c.id == courseID) return c;
        }
        return null;
    }
}
