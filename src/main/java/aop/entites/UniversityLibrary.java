package aop.entites;

import aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class UniversityLibrary extends AbstractLibrary {

    public void addBook(){
        System.out.println("Add book to University Library");
    }

    public void getBook( ){
        System.out.println("Get book back from University!");
    }

    public void getBook(String bookName){
        System.out.println("Get book back from University!" + bookName);
    }

    public void getBook(Book book){
        System.out.println("We get book from University lib: " + book.getName());
    }

    public void returnBook(){
        System.out.println("Return book to University Library");
    }

    public void addMagazine(){
        System.out.println("Add magazine to University Library");
    }

    public void getMagazine(){
        System.out.println("Get magazine back from University!");
    }

    public void getMagazine(int a){
        System.out.println("Get magazine back from University!");
    }

    public void returnMagazine(){
        System.out.println("Return magazine to University Library");
    }
}
