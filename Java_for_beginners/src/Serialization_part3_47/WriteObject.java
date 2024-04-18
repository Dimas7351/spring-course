package Serialization_part3_47;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        Person person1 = new Person(1,"Bob");
//        Person person2 = new Person(2,"Mike");

        // Любое расширение может быть у файла, но обычно для записи бинарных файлов используется .bin
        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(person1);
//            oos.writeObject(person2);


            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
