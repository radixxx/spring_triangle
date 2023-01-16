package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public void getBook())") // it's a PointCut - when should execute Aspect code
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: Attempt to get the book");
    }

}
