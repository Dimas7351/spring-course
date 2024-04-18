package Equals_and_StringPool_42;

public class Test {
    public static void main(String[] args) {
        //  animal1      ->    {1}
        //  animal2      ->    {1}

        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);
        Animal animal3 = animal1;

        System.out.println(animal1.equals(animal2));
        System.out.println(animal3==animal1);
        System.out.println(animal1==animal2);


        String string1 = "Hello";      //    string1   ->   {"Hello"}
        String string2 = "Hello";      //    string2   ->   {"Hello"}  Джава находит такой же объект и указывает на него ссылку

        System.out.println(string1==string2);
        System.out.println(string1.equals(string2));

        String string3 = new String("Hello");
        String string4 = new String("Hello");
        System.out.println(string3==string4);
    }
}

class Animal{
    private int id;

    public Animal(int id){
        this.id = id;
    }

    public boolean equals(Object obj){
        Animal otherAnimal = (Animal) obj;
        return this.id==otherAnimal.id;
    }
}
