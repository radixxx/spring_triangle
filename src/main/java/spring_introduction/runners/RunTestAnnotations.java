package spring_introduction.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_introduction.MyConfig;
import spring_introduction.entities.Person;
import spring_introduction.entities.Pet;

public class RunTestAnnotations {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Pet murzyk = context.getBean("catBean", Pet.class);
        murzyk.say();

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        context.close();

    }

}
