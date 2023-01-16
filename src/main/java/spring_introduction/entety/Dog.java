package spring_introduction.entety;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("singleton")
public class Dog implements Pet{
    private String name;
    public Dog() {
        System.out.println("Dog bean is created !");
    }
    @Override
    public void say() {
        System.out.println("Bow Bow");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("Class Dog: init");
    }

    public void destroy() {
        System.out.println("Class Dog: destroy");
    }
    @Override
    public String toString() {
        return "Dog" +
                "name: " + name;
    }
}
