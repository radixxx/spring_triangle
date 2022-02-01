package aop.aspects.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {


    @Pointcut("execution(* aop.entites.UniversityLibrary.get*())")
    private void allGetMethodsFromUniLib(){}


    @Pointcut("execution(* aop.entites.UniversityLibrary.return*())")
    private void allReturnMethods(){}

    @Pointcut("allGetMethodsFromUniLib() || allReturnMethods()")
    private void allGetAndReturnMethodsFromUniLib(){}

    //Universal Pointcut
    @Pointcut("execution(* aop.entites.UniversityLibrary.*(..))")
    private void allMethodsFromUniLibrary(){}

    @Pointcut("execution(* aop.entites.UniversityLibrary.returnMagazine())")
    public void returnMagazineFromUniLib(){}

    //Pointcut except one of the both methods
    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLib()")
    public void allMethodsExceptReturnMagazine(){}


    @Before("allGetMethodsFromUniLib()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: Get-log #1");
    }


    @Before("allReturnMethods()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: Return-log #2");
    }

    @Before("allGetAndReturnMethodsFromUniLib()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: Get_Return-log #3");
    }

    @Before("allMethodsFromUniLibrary()")
    public void beforeAllMethodsFromUniLibraryAdvice(){
        System.out.println("beforeAllMethodsFromUniLibraryAdvice: Get-Add-log #4");
    }

    @Before("allMethodsExceptReturnMagazine()")
    public void beforeAllMethodsExceptReturnMagazineAdvice(){
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: All-!Return #5");
    }

}
