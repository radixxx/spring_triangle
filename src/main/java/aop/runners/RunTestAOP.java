package aop.runners;

import aop.Library;
import aop.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("libraryBean", Library.class);
        library.getBook();

        context.close();


    }
}
