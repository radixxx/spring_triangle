package aop.aspects.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {

    @Before("aop.aspects.pointcuts.MyPointcuts.allGetMethods()")
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: validation permissions to get: " + "magazine/book");
    }

    @Before("aop.aspects.pointcuts.MyPointcuts.allAddMethods()")
    public void beforeAddSecurityAdvice(){
        System.out.println("beforeAddSecurityAdvice: validation permissions to get:" + "magazine/book");
        System.out.println("------------------------------");
    }

}
