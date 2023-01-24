package aop.entity;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary{
    public void getBook(String name) {
            System.out.println("Get book: " + name + " from School library");
    }

    public void returnMagazine(){
        System.out.println("Return School magazine!");
    }
}
