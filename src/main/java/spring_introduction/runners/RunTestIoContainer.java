package spring_introduction.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.entities.Pet;

public class RunTestIoContainer {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

        Pet pet1 = context.getBean("myPet1", Pet.class);
        pet1.say();

        context.close();
    }
}
