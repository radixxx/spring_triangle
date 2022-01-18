package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTestConfigWithAnnotations {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");


        Person person = context.getBean("personBean", Person.class);
         person.callYourPet();

        context.close();

    }

}
