package aop.aspects.advice;

import aop.entites.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: logging "
                + "get list of students Before method getStudents");
    }

    @AfterReturning(pointcut = "execution(* getStudents())",
            returning = "students")
    public void afterGetStudentsLoggingAdvice(List<Student> students) {
        Student firstStudent = students.get(0);

        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr. " + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 0.5;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterGetStudentsLoggingAdvice: logging "
                + "get list of students After method getStudents");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingStudentsLoggingAdvice(Throwable exception){
        System.out.println("afterThrowingStudentsLoggingAdvice: logging throwing: " + exception);
    }


    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: finishing correct"
                + " or throw exception");
    }

}
