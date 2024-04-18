package Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Не сделана часть про многопоточность


        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbye");
        list.add("a");
        list.add("ab");

        // Сортировка через анонимный класс
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length()>o2.length())
//                    return 1;
//                else if (o1.length()<o2.length())
//                    return -1;
//                else
//                    return 0;
//            }
//        });

        // Лямбда, переданная в переменную
        Comparator<String> comparator = (o1,o2) -> {
            if(o1.length()>o2.length())
                return 1;
            else if (o1.length()<o2.length())
                return -1;
            else
                return 0;
        };

        // Лямбда
//        list.sort((o1,o2) -> {
//            if(o1.length()>o2.length())
//                    return 1;
//                else if (o1.length()<o2.length())
//                    return -1;
//                else
//                    return 0;
//        });

        list.sort(comparator);
        System.out.println(list);
    }
}
