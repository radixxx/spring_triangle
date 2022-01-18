package spring_introduction.entities;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class Dog implements Pet {
    @Autowired
    public Dog() {
        System.out.println("Dog bean is created !");
    }

    @Override
    public void say() {
        System.out.println("Bow Bow");
    }

    public void init() {
        System.out.println("Class Dog: init method");
    }

    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }

}
