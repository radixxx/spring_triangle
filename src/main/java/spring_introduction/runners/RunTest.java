package spring_introduction.runners;

import spring_introduction.entety.Cat;
import spring_introduction.entety.Pet;

public class RunTest {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.say();
    }
}
