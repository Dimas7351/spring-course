package Reading_from_file_36;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator; // Получаем разделитель системы
//        String filePath = "/home/dimas735/java_test.txt";
        String filePath = separator + "home" + separator + "dimas735" + separator + "java_test.txt";
        File file = new File(filePath);

        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] numbersString = line.split(" "); // \\.  - экранирование точки - разделитель
        int[] numbers = new int[3];
        int counter = 0;

        for (String number : numbersString){
            numbers[counter++] = Integer.parseInt(number);
        }
        System.out.println(Arrays.toString(numbers));
//        while(scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
//        }

        scanner.close();
    }
}
