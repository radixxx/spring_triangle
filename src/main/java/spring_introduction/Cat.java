package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("catBean")
public class Cat implements Pet {
    @Autowired
    public Cat() {
        System.out.println("Cat bean is created !");
    }

    @Override
    public void say() {
        System.out.println("Meow Meow");
    }
}
