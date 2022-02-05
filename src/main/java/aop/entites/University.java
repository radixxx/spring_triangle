package aop.entites;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Tom Dart", 3, 8.1);
        Student st2 = new Student("Anton Verdi", 2, 9.6);
        Student st3 = new Student("Peter Gan", 4, 7.5);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Start of work method: getStudents");
        System.out.println(students.get(6));
        System.out.println("Info from method getStudents: ");
        System.out.println(students);
        return students;
    }


}
