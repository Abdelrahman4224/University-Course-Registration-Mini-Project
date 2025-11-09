package universityregistration;

import java.util.LinkedList;

public class Student {
    int id;
    LinkedList<Course> courses;

    public Student(int id) {
        this.id = id;
        this.courses = new LinkedList<>();
    }
}
