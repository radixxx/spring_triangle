package aop.runner;

import aop.ConfigAOP;
import aop.entity.Student;
import aop.entity.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RunTestAOPAfter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAOP.class);

        //Before execution ending 'students' @AfterReturn - always modify data !

        University university = context.getBean(University.class);
        university.addStudent();
        try{
            List<Student> students = university.getStudentList();
            System.out.println(students);
        }catch (Exception e){
            e.printStackTrace();
        }

        context.close();
    }
}
