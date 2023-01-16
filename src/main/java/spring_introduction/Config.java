package spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring_introduction.entety.Cat;
import spring_introduction.entety.Pet;

//@Configuration
//@ComponentScan("spring_introduction")
public class Config {

    @Bean
    public Pet catBean(){
        return new Cat();
    }

}
