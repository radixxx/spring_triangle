package aop.entity;

import org.springframework.stereotype.Component;

@Component("libBean")
public class Library {
    public void getBook(){
        System.out.println("Get book!");
    }

}
