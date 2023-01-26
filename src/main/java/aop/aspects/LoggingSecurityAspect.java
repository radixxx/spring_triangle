package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingSecurityAspect {

    /*
    *We can re-use one Pointcut for related methods
    * @Pointcut("execution(* get*())")
    * private void allGetMethods(){}
    * */

    @Pointcut("execution(* aop.entity.SchoolLibrary.get*())")
    private void allGetMethodsFromSchoolLibrary(){}

    @Before("allGetMethodsFromSchoolLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: Log #1");
    }

    @Pointcut("execution(* aop.entity.SchoolLibrary.return*())")
    private void allReturnMethodsFromSchoolLibrary(){}

    @Before("allReturnMethodsFromSchoolLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: Log #2");
    }

    @Pointcut("execution(* aop.entity.SchoolLibrary.add*())")
    private void allAddMethodsFromSchoolLibrary(){}

    @Before("allAddMethodsFromSchoolLibrary()")
    public void beforeAddMethodsFromSchoolLibrary(){
        System.out.println("beforeGetLoggingAdvice: Log #3");
    }

    /*********Combain***********/
    @Pointcut("allGetMethodsFromSchoolLibrary() || allAddMethodsFromSchoolLibrary()")
    public void beforeAllGetAddMethodsFromSchoolLibrary(){
        System.out.println("beforeGetAddLoggingAdvice: Log #4");
    }

    @Pointcut("allReturnMethodsFromSchoolLibrary() || allGetMethodsFromSchoolLibrary()")
    private void beforeAllReturnGetmethods(){
        System.out.println("beforeAllReturnGetmethods: Log #5");
    }

/*
    @Pointcut("execution(* get*())")
    private void allGetMethods(){}

    @Pointcut("execution(* return*())")
    private void allReturnMethods(){
    }

    @Before("allReturnMethods()")
    public void beforeReturnSecurityAdvice(){
        System.out.println("beforeReturnSecurityAdvice: Attempt to Return book");
    }

    @Before("allGetMethods()") // it's a PointCut - when should execute Aspect code
    public void beforeGetLoggingAdviceWithoutParams(){
        System.out.println("beforeGetBookAdviceWildcard: Attempt to get the book");
    }
    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: Check permissions to get the book/magazine");
    }*/
}
