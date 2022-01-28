package aop.entites;

import aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class UniversityLibrary extends AbstractLibrary {

    @Override
    public void getBook(){
        System.out.println("Get book back from University!");
    }

}
