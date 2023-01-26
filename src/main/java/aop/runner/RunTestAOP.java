package aop.runner;

import aop.ConfigAOP;
import aop.entity.Book;
import aop.entity.SchoolLibrary;
import aop.entity.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAOP.class);

        Book book = context.getBean(Book.class);

        UniversityLibrary library = context.getBean(UniversityLibrary.class);
       library.getMagazine();
       library.getBook();
       library.returnBook();

        context.close();
    }
}
