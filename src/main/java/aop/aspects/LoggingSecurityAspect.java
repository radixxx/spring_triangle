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

    @Pointcut("execution(* get*())")
    private void allGetMethods(){}

    @Pointcut("execution(* return*())")
    private void allReturnMethods(){}

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
    }
}
