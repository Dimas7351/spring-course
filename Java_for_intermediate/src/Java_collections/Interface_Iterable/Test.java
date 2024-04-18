package Java_collections.Interface_Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        int idx = 0;
        // Before Java 5
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if(idx==1)
                iterator.remove(); // не принимает аргументы, так как iterator уже имеет указатель на элемент
            idx++;
        }
        // Java 5
        for(int x: list){
            // Нельзя удалять элементы, пока двигаемся в foreach
//            list.remove(1);

            System.out.println(x);
    }}
}
