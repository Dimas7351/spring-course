package Exceptions_37_40;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions1 {
    public static void main(String[] args)  {

        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        System.out.println("After try/catch");
    }

    public static void readFile() throws FileNotFoundException {
        File file = new File("sosi");
        Scanner scanner = new Scanner(file);
    }
}
