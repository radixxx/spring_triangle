package spring_introduction;


import org.springframework.context.annotation.*;
import spring_introduction.entities.Cat;
import spring_introduction.entities.Person;
import spring_introduction.entities.Pet;

@Configuration
@ComponentScan("spring_introduction")
@PropertySource("classpath:triangleApp.properties")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public Person personBean(){
        return new Person(catBean());
    }

}
