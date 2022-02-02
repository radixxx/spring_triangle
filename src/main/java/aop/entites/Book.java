package aop.entites;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Money heist")
    private String name;

    @Value("Java programming")
    private String author;

    @Value("2020")
    private String yearsOfPublication;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearsOfPublication() {
        return yearsOfPublication;
    }
}
