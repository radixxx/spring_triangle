package spring_introduction.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.entety.Person;

public class RunTestDI {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }
}
