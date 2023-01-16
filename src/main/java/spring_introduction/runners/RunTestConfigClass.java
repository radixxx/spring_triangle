package spring_introduction.runners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Config;
import spring_introduction.entety.Person;


public class RunTestConfigClass {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Person person = context.getBean(Person.class);
        person.callYourPet();

        context.close();
    }

}
