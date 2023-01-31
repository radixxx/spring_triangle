package aop.aspects;

import aop.entity.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Before("execution (* getStudentList())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: get log Students list");
    }

    @AfterReturning(pointcut= "execution (* getStudentList())",
            returning = "studentList")
    public void afterGetStudentsLoggingAdvice(List<Student> studentList){
        Student firstStudent = studentList.get(0);

        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr. " + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 1;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterGetStudentsLoggingAdvice: get log Students list");
    }
    @AfterThrowing(value = "execution (* getStudentList())"
            ,throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentsLoggingAdvice: logging" + exception);
    }
}
