package aop.runners;

import aop.MyConfig;
import aop.entites.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOP3 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);


        System.out.println("Starts: ");
        UniversityLibrary library = context.getBean("libraryBean", UniversityLibrary.class);
        String bookName = library.returnBook();
        System.out.println("Return to library: " + bookName);

        context.close();
        System.out.println("end's");
    }

}
