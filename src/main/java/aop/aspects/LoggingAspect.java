package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    /*
    * this is example of pointcut for the one method with Parameter
    * */
/*
    @Before("execution(public void aop.entites.UniversityLibrary.getBook(String))") // this is pointcut
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: attempt to get book !");
    } */

    /*
    * this is example of pointcut + wildcard its universal for
    * the all methods suitable for all requirements input types
    * */

   /* @Before("execution(public void * (..))") // this is pointcut + wildcard
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: attempt to get book !");
    } */

    @Before("execution(public void * (aop.entites.Book))") // this is pointcut + wildcard
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: attempt to get book !");
    }

    @Before("execution(public * returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: attempt to return book !");
    }
}
