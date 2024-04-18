package Java_collections.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        // Операции над множествами:

        // union - объединение множеств
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);

        // intersection - пересечение
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);  // Оставляет все одинаковые элементы
        System.out.println(intersection);

        // difference - разность множеств
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2); // Удаляются все элементы, которые совпадают с set2
        System.out.println(difference);
    }
}
