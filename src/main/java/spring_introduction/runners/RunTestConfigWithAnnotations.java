package spring_introduction.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.entities.Person;

public class RunTestConfigWithAnnotations {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");


        Person person = context.getBean("personBean", Person.class);
         person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();

    }

}
