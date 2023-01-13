package spring_introduction.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.entety.Dog;

public class RunTestDIMultiContext {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext1.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.say();

        context.close();
    }
}
