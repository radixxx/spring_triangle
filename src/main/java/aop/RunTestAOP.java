package aop;

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
        library.getBook(book);
        library.returnBook();
        library.getMagazine();

        SchoolLibrary schoolLibrary = context.getBean(SchoolLibrary.class);
        schoolLibrary.getBook("Peace and War");
        schoolLibrary.returnMagazine();



        context.close();
    }
}
