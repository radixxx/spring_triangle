package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTestDISingleContext {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext1.xml");

        //bean scope is 'singleton'
        Dog dog = context.getBean("myPetDog", Dog.class);
        Dog yourDog = context.getBean("myPetDog", Dog.class);

        Cat grey = context.getBean("myPetCat", Cat.class);
        Cat black = context.getBean("myPetCat", Cat.class);

        System.out.println(grey);
        System.out.println(black);

        //bean scope is 'prototype'
        Dog shepherd_dog = context.getBean("myPetDog", Dog.class);
        Dog terrier = context.getBean("myPetDog", Dog.class);

        shepherd_dog.setName("Gav");
        terrier.setName("Beam");

        System.out.println(shepherd_dog);
        System.out.println(terrier);

        context.close();

    }
}
