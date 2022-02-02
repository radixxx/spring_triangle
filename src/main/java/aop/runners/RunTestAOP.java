package aop.runners;

import aop.MyConfig;
import aop.entites.Book;
import aop.entites.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary uLibrary = context.getBean("libraryBean", UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);

        System.out.println("======================");
        uLibrary.getBook();
        System.out.println("======================");
        uLibrary.addBook("Tom", book);
        System.out.println("======================");
        uLibrary.addMagazine();
        //uLibrary.returnMagazine();


       // uLibrary.getBook(book);

        context.close();


    }
}
