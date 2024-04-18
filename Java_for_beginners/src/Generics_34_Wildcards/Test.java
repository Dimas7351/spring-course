package Generics_34_Wildcards;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<Animal> listOfAnimal = new ArrayList<>();

        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));


        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        test(listOfAnimal);
        test(listOfDogs); // Так передать нельзя, полиморфизм не работает, если дальше сделать List<Animal>, а не wildcard
    }

    public static void test(List<? extends Animal> list){  // Можно сделать List<?> и передавать list с любыми типами. Либо сделать super (не extends) Animal, тогда в листе будут объекты выше класса Aimal. P.S. Бесполезно, т к будет только Object
        for(Animal animal : list){
            System.out.println(animal);
            animal.eat();
        }
    }
}
