package aop;

import aop.entity.Library;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAOP.class);

            Library library = context.getBean("libBean", Library.class);
            library.getBook();

            context.close();
    }
}
