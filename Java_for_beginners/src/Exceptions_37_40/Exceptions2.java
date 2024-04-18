package Exceptions_37_40;

import java.io.IOException;
import java.util.Scanner;

public class Exceptions2 {
    public static void main(String[] args) throws ScannerException{
        Scanner scanner = new Scanner(System.in);

        while(true){
            int x = Integer.parseInt(scanner.nextLine());

            if (x!=0){
                throw new ScannerException("Пользователь ввел не 0");
//                try {
//                    throw new IOException();
//                } catch (IOException e) {
//                    System.out.println("Было введено число, отличное от 0");
//                }
            }
        }
    }
}
