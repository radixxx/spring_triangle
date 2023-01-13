package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTestConfigWithAnnotations {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Cat greyCat = context.getBean("catBean", Cat.class);
        greyCat.say();

        Dog dog = context.getBean("dog", Dog.class);
        dog.say();

        Person  person = context.getBean("personBean", Person.class);
        System.out.println("Person params: \n" +  person.getSurname() + person.getAge());

        person.callYourPet();

        context.close();
    }
}
