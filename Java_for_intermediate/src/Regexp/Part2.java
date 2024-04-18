package Regexp;

import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        String s = "Hello3124there345434hey";
        String[] words = s.split("\\d+");
        System.out.println(Arrays.toString(words));

        String b = "Hello there way";
        b = b.replace(" ",".");
        System.out.println(b);

        //replaceAll - для регулярных выражений
        String tt = "hello312432there343241hey";
        String first = tt.replaceFirst("\\d+", "-");
        tt = tt.replaceAll("\\d+","-");
        System.out.println(tt);
        System.out.println(first);


    }
}
