package Abstract_classes_41;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Cat cat = new Cat();
        Dog dog = new Dog();
        //Animal animal = new Animal(); - т к класс абстрактный
        cat.makeSound();
        cat.eat();
        dog.makeSound();
        dog.eat();

    }
}
