package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTestDIMultiContext {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext1.xml");


    }
}
