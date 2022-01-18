package spring_introduction.runners;

import spring_introduction.entities.Cat;
import spring_introduction.entities.Pet;

public class RunTest {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.say();
    }
}
