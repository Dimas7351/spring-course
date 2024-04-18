package Serialization_part3_47;


import java.io.*;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin"))){
            /*** Если мы добавили в try (...)
            FileInputStream fis = new FileInputStream("people.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
             ***/


            Person person1 = (Person) ois.readObject();
//            Person person2 = (Person) ois.readObject();

            System.out.println(person1);
//            System.out.println(person2);

            ois.close(); // если добавили создание ObjectInputStream возле try (...)
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
