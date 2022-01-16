package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTestDISecondContext {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext1.xml");

        //bean scope is 'singleton'
        Cat grey = context.getBean("myPet", Cat.class);
        Cat black = context.getBean("myPet", Cat.class);

        System.out.println(grey);
        System.out.println(black);

        //bean scope is 'prototype'
        Dog shepherd_dog = context.getBean("myPetDog", Dog.class);
        shepherd_dog.say();

        Dog terrier = context.getBean("myPetDog", Dog.class);
        terrier.say();

        System.out.println(shepherd_dog);
        System.out.println(terrier);

        context.close();

    }
}
