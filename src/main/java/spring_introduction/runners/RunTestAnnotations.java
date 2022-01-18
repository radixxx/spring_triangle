package spring_introduction.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_introduction.MyConfig;
import spring_introduction.entities.Person;

public class RunTestAnnotations {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();

    }

}
