package aop.runners;

import aop.MyConfig;
import aop.entites.Student;
import aop.entites.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RunTestAOP2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();

        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }

        context.close();

    }

}
