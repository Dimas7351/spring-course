package Serialization_part1_45;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
//        Person person1 = new Person(1,"Bob");
//        Person person2 = new Person(2,"Mike");
        Person[] people = {new Person(1,"Bob"), new Person(2,"Mike"),new Person(3,"Tom")};

        // Любое расширение может быть у файла, но обычно для записи бинарных файлов используется .bin
        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Запись массива как объекта
            oos.writeObject(people);

//            oos.writeObject(person1);
//            oos.writeObject(person2);

          /*** Запись массива поэлементно
            oos.writeInt(people.length);

            for (Person person : people){
                oos.writeObject(person);
            } ***/

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
