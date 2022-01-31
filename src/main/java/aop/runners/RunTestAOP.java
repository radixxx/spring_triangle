package aop.runners;

import aop.entites.SchoolLibrary;
import aop.entites.UniversityLibrary;
import aop.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary uLibrary = context.getBean("libraryBean", UniversityLibrary.class);
        uLibrary.getBook();
        uLibrary.getBook();
        uLibrary.getMagazine();

        uLibrary.returnBook();

        SchoolLibrary sLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        sLibrary.getBook();
        sLibrary.returnBook();

        context.close();


    }
}
