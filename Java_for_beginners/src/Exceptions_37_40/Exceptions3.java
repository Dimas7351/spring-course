package Exceptions_37_40;

import java.io.File;
import java.util.Scanner;

public class Exceptions3 {
    public static void main(String[] args) {


        // Checked Exception (Compile Time Exception - во время компиляции)
        // Unchecked Exception (Runtime Exception - во время выполнения программы)

        /*** Checked Exception
         File file = new File("test");
         Scanner scanner = new Scanner(file);
         ***/

        //Unchecked Exception
        //int g = 1 / 0;

//        String name = null;
//        name.length();

        // IndexOutOfBound
        int[] arr = new int[2];
        try{
            System.out.println(arr[2]);
        } catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Index out of bounds");
        }
    }
}
