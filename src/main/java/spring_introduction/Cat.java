package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet {
    @Autowired
    public Cat() {
        System.out.println("Cat bean is created !");
    }

    @Override
    public void say() {
        System.out.println("Meow Meow");
    }

    public void init() {
        System.out.println("Class Cat: init method");
    }

    public void destroy() {
        System.out.println("Class Cat: destroy method");
    }
}
