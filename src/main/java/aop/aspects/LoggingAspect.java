package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/*Pointcut pattern*
* execution ( modifiers-pattern ? return-type-pattern declaring-type-pattern?
* method-name-pattern(parameters-pattern) throws-pattern? )
* */

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public * get*(..))") // it's a PointCut - when should execute Aspect code
    public void beforeGetBookAdviceWildcard(){
        System.out.println("beforeGetBookAdviceWildcard: Attempt to get the book");
    }
    @Before("execution(public * get*())") // it's a PointCut - when should execute Aspect code
    public void beforeGetBookAdviceWithoutParams(){
        System.out.println("beforeGetBookAdviceWildcard: Attempt to get the book");
    }
    @Before("execution(public * getBook(aop.entity.Book, ..))") // it's a PointCut - when should execute Aspect code
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: Attempt to get the book");
    }

    @Before("execution( * return*())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: Attempt to return the book");
    }
    @Before("execution(* *(..))")
    public String testPointCutMethod(){
        return "Test Point Cut Method";
    }
}
