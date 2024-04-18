package Java_collections.Hash_map;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        // В MAP не гарантируется вывод пар в том же порядке, в котором они были записаны
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");

        // Entry - пара ключ=значение
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


//        System.out.println(map);
//
//        map.put(3, "Соси");
//
//        System.out.println(map);
//
//        System.out.println(map.get(1));
//        System.out.println(map.get(7));
    }
}
