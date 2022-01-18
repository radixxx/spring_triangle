package spring_introduction.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
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
