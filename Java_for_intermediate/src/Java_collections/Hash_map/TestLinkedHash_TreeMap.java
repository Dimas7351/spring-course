package Java_collections.Hash_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestLinkedHash_TreeMap {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>(); // Внутри не гарантируется порядок

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // В каком порядке пары ключ=значение были добавлены, в таком они и вернутся

        Map<Integer, String> treeMap = new TreeMap<>(); // Гаранирует сортировку по ключу (естественный порядок)

//        testMap(hashMap);
//        testMap(linkedHashMap);
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map){
        map.put(39, "Bob");
        map.put(12, "Alice");
        map.put(69, "Ahh");
        map.put(0, "Tom");
        map.put(1500, "Karam");
        map.put(7, "Bob");

        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
