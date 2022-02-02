package aop.aspects.advice;

import aop.entites.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
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

    // Use JoinPoint get signature method
    @Before("aop.aspects.pointcuts.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod: " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType: " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName: " + methodSignature.getName());

        if (methodSignature.getName().equals("addBok")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Info about book: name - " + myBook.getName() + ", author - "
                            + myBook.getAuthor() + "year of publication - " + myBook.getYearsOfPublication());
                } else if (obj instanceof String)
                    System.out.println("This book added: " + obj);
            }
        }

        System.out.println("beforeAddLoggingAdvice: log" + "attemp to get book/magazine");
        System.out.println("------------------------------");
    }

    @Before("execution(public void * (aop.entites.Book))") // this is pointcut + wildcard
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: attempt to get book !");
    }

    @Before("execution(public * returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: attempt to return book !");
    }
}
