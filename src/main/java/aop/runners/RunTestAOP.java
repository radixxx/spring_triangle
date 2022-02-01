package aop.runners;

import aop.entites.Book;
import aop.entites.SchoolLibrary;
import aop.entites.UniversityLibrary;
import aop.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary uLibrary = context.getBean("libraryBean", UniversityLibrary.class);
        uLibrary.addBook();
        uLibrary.getBook();
        uLibrary.getMagazine();
        uLibrary.returnMagazine();

       // Book book = context.getBean("book", Book.class);
       // uLibrary.getBook(book);

        context.close();


    }
}
