package Java_collections.Linked_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
//        linkedList.add(1);
//        linkedList.get(0);
//        linkedList.size();
//        linkedList.remove(0);

        measureTime(linkedList);
        measureTime(arrayList);

    }

    private static void measureTime(List<Integer> list){

        long start = System.currentTimeMillis();

        for(int i = 0; i<100000; i++){
            list.add(0,i);  // Добавление в начало
        }

//        for(int i = 0; i<100000; i++){
//            list.get(i);
//        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
