package Serialization_part3_47;

import java.io.Serializable;


public class Person implements Serializable {
    private static final long serialVersionUID = 233345;  // было 23334

    // private transient int id;
    private int id; // Если transient на примитивных типах данных, будет = 0, на ссылочных типа String = null
    private  String name; // transient - говорим, что не хотим сериализовывать это поле
    private int age;
    private byte Type;

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