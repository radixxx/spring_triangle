package aop.entity;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary{
    public void getBook(Book book){
        System.out.println("Get book from University library: " + book);
    }

    public void returnBook(){
        System.out.println("Return book from University library");
    }

    public void getMagazine(){
        System.out.println("Get magazine from University library");
    }
}
