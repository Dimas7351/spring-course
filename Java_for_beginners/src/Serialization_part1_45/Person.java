package Serialization_part1_45;

import java.io.Serializable;

// Необходимо implenemt от интерфейса, чтобы можно было сериализовать
public class Person implements Serializable {
    private int id;
    private String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return id + " : " + name;
    }
}
