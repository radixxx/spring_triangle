package aop.entites;

import aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class UniversityLibrary extends AbstractLibrary {

    public void getBook(String bookName){
        System.out.println("Get book back from University!" + bookName);
    }

    public void getBook(Book book){
        System.out.println("We get book from Univer lib: " + book.getName());
    }

    public void getMagazine(int a){
        System.out.println("Get magazine back from University!");
    }

    public void returnBook(){
        System.out.println("Return book from University Library");
    }
}
