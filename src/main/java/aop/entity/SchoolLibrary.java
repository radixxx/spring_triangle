package aop.entity;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary{
    public void getBook(String name) {
            System.out.println("Get book: " + name + " from School library");
    }

    public void returnBook(){
        System.out.println("Return School book!");
    }

    public void getMagazine(){
        System.out.println("Get magazine from School library");
    }

    public void returnMagazine(){
        System.out.println("Return School magazine");
    }

    public void addBook(){
        System.out.println("Get book from School library");
    }

    public void addMagazine(){
        System.out.println("add magazine to School library");
    }

}
