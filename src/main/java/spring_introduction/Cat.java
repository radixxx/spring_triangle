package spring_introduction;

import org.springframework.stereotype.Component;
@Component("catBean")
public class Cat implements Pet{
    public Cat() {
        System.out.println("Cat bean is created !");
    }
    @Override
    public void say() {
        System.out.println("Meow Meow");
    }
    public void init() {
        System.out.println("Class Cat: init");
    }
    public void destroy() {
        System.out.println("Class Cat: destroy");
    }
    @Override
    public String toString() {
        return "Cat: ";
    }
}
