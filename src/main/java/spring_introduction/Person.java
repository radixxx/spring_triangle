package spring_introduction;

public class Person {

    Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public Person() {
        System.out.println("Person bean is created");
    }

    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hi my Pet !");
        pet.say();
    }

}
