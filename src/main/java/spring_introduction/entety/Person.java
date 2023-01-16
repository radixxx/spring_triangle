package spring_introduction.entety;

import org.springframework.beans.factory.annotation.Value;

//@Component("personBean")
public class Person {
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    //@Autowired
/*    public Person(@Qualifier("catBean") Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }*/

    public Person() {
        System.out.println("Cat bean is created !");
    }

    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public void callYourPet(){
        System.out.println("Hi my Pet !");
        pet.say();
    }

}
