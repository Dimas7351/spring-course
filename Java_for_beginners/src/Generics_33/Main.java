package Generics_33;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//////////////////////// Java 5 //////////////////
        List animals = new ArrayList();
        Animal ourAnimal = new Animal();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        animals.add(ourAnimal);

        String animal = (String) animals.get(1); ///Downcasting
        System.out.println(animal);


        ////////////////// Generics ///////////////
        List <String> animals2 = new ArrayList<String>();
        animals2.add("cat");
        animals2.add("dog");
        animals2.add("frog");
        //animals2.add(ourAnimal);

        String animal2 = animals2.get(2);


        ////////////////// Java 7 Modified Generics ///////////////

        List<String> animals3 = new ArrayList<>();

        System.out.println(animal2);
    }
}

class Animal{

}