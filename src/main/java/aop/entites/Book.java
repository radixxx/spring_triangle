package aop.entites;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Money heist")
    private String name;

    public String getName() {
        return name;
    }
}
