package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTestConfigWithAnnotations {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Cat greyCat = context.getBean("cat", Cat.class);
        greyCat.say();

        context.close();

    }

}
