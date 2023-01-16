package spring_introduction.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_introduction.Config1;
import spring_introduction.entety.Cat;
import spring_introduction.entety.Person;

public class RunTestConfig1Class {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config1.class);

        Cat cat = context.getBean(Cat.class);
        cat.say();

        Person person = context.getBean("personBean", Person.class);
        //person.callYourPet();

        context.close();
    }

}
