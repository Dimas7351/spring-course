package Exceptions_37_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Exceptions4 {
    public static void main(String[] args) {

//        try{
//            run();
//        } catch (IOException e){
//        e.printStackTrace();
//    } catch (ParseException e){
//            e.printStackTrace();
//        }
//

        // Multicatch, когда хотим одинаково обработать несколько исключений
//        try {
//            run();
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }

        try{
            run();
        } catch (Exception e){

       // } catch (ParseException e){

        }
    }
    public static void run() throws IOException, ParseException, IllegalArgumentException {

    }
}
