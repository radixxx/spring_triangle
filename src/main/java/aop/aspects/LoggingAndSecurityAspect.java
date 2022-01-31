package aop.aspects;

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
    private void allGetAndReturnMethodsFromUniLib(){

    }

    @Before("allGetMethodsFromUniLib()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: get-log #1");
    }


    @Before("allReturnMethods()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: return-log #2");
    }

    @Before("allGetAndReturnMethodsFromUniLib()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: get_return-log #3");
    }
















  /*  @Pointcut("execution(* get*())")
    private void allGetMethods(){}

    @Before("allGetMethods()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: attempt to get book !");
    }

    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: validation permissions to get: " + "magazine/book");
    }*/

}
