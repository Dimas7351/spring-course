package Lambda.Part2;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArray(arr1);
        fillList(list1);

        System.out.println(Arrays.toString(arr1));
        System.out.println(list1);

//        for(int i = 0; i<10; i++){
//            arr1[i] = arr1[i]*2;
//            list1.set(i, list1.get(i)*2);
//        }

        // map method
        arr1 = Arrays.stream(arr1).map(a -> a*2).toArray();
        list1 = list1.stream().map(a -> a*2).collect(Collectors.toList());

        arr1 = Arrays.stream(arr1).map(a -> 3).toArray();
        arr1 = Arrays.stream(arr1).map(a -> a+1).toArray();

        System.out.println(Arrays.toString(arr1));
        System.out.println(list1);

        // filter method
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArray(arr2);
        fillList(list2);

        // lambda в filter должна возвращать true/false
        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a%2 != 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        // forEach
//        Arrays.stream(arr2).forEach(a -> System.out.println(a));
//        list2.stream().forEach(System.out::println);

        // reduce method
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillList(list3);
        fillArray(arr3);

        // accumulator - переменная-счетчик
        // если указать начальное значение аккумулятора, то итерация начинается с 0 элемента, иначе с 1, так как аккумулятор взял значение 0 элемента
        int sum1 = Arrays.stream(arr3).reduce((accumulator, current) -> accumulator+current).getAsInt();
        int sum3 = Arrays.stream(arr3).reduce(0,(accumulator, current) -> accumulator+current); // можно задать значение аккумулятору (начальное значение), то можно не вызывать getAsInt()
        int sum2 = list3.stream().reduce((acc, b) -> acc*b).get();

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);


        // Вызов нескольких методов
        int[] arr4 = new int[10];
        fillArray(arr4);

        int[] newArray = Arrays.stream(arr4).filter(a -> a%2!=0).map(a -> a*2).toArray();
        System.out.println(Arrays.toString(newArray));


        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        System.out.println(set);
        set = set.stream().map(a -> a*3).collect(Collectors.toSet());
        System.out.println(set);

    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i<10; i++)
            list.add(i+1);
    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i<10; i++)
            arr[i] = i+1;
    }
}
