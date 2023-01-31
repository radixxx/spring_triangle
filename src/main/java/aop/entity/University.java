package aop.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(){
        Student student1 = new Student("Tom Datt", 2, 7);
        Student student2 = new Student("Antony Morri", 1, 6);
        Student student3 = new Student("Jimmy Pall", 3, 8);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
    }

    public List<Student> getStudentList(){
        System.out.println(studentList.get(4));
        System.out.println("Info from getStudent: " + studentList);
        return studentList;
    }
}
