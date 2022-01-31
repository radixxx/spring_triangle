package aop.entites;

import aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class UniversityLibrary extends AbstractLibrary {

    @Override
    public void getBook(){
        System.out.println("Get book back from University!");
    }

    public void getMagazine(){
        System.out.println("Get magazine back from University!");
    }

    public void returnBook(){
        System.out.println("Return book from University Library");
    }
}
