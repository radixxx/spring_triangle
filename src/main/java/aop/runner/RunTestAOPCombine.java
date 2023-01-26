package aop.runner;

import aop.ConfigAOP;
import aop.entity.SchoolLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTestAOPCombine {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAOP.class);

        SchoolLibrary schoolLibrary = context.getBean(SchoolLibrary.class);
        schoolLibrary.addBook();
        schoolLibrary.returnMagazine();
        schoolLibrary.addBook();


        context.close();
    }

}
