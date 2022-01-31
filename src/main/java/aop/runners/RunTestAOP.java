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
        uLibrary.getBook("From Zero to One");

        uLibrary.getMagazine(18);

        Book book = context.getBean("book", Book.class);
        uLibrary.getBook(book);


       /* uLibrary.returnBook();

        SchoolLibrary sLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        sLibrary.getBook();
        sLibrary.returnBook();
*/
        context.close();


    }
}
