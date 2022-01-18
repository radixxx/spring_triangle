package spring_introduction.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.entities.Cat;

public class RunTestScope {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Cat murzik = context.getBean("cat", Cat.class);
        Cat bruce = context.getBean("cat", Cat.class);

        System.out.println("Both variables linked to the same obj: " + (murzik == bruce));

        context.close();

    }
}
