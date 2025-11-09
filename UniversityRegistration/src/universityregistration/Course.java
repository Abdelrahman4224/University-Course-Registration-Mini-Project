package universityregistration;

import java.util.LinkedList;

public class Course {
    int id;
    LinkedList<Student> students;

    public Course(int id) {
        this.id = id;
        this.students = new LinkedList<>();
    }
}
