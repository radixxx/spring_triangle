package aop.entites;

import aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Get book back from School !");
    }

    public String returnBook(){
        System.out.println("Return book from School Library");
         return "OK";
    }
}
