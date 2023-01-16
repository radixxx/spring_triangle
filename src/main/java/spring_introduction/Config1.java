package spring_introduction;

import org.springframework.context.annotation.*;
import spring_introduction.entety.Cat;
import spring_introduction.entety.Person;
import spring_introduction.entety.Pet;

@Configuration
@ComponentScan("spring_introduction")
@PropertySource("classpath:triangleApp.properties")
public class Config1 { 

    @Bean
    @Scope("singleton")
    public Pet catBean(){
        return new Cat();
    }
    @Bean
    @Scope("singleton")
    public Person personBean(){
        return new Person();
    }

}
