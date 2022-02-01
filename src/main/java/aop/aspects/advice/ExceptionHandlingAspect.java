package aop.aspects.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(50) //!Important less number - mean most greeter priority
public class ExceptionHandlingAspect {
    @Before("aop.aspects.pointcuts.MyPointcuts.allGetMethods()")
    public void beforeExceptionHandlingAdvice(){
        System.out.println("beforeExceptionHandlingAdvice: catch " + "exception trying to get book/magazine");
    }
}
