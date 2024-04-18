package Java_collections.Interface_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("dog");
        animals.add("cat");
        animals.add("I");
        animals.add("me");
        animals.add("frog");
        animals.add("bird");

        Collections.sort(animals, new StringLengthComparator()); // сортируем по длине

        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

//        numbers.sort(new BackwardsIntegerComparator());

        // Можно создать анонимный класс, если хотим использовать только один раз
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2)
                    return -1;
                else if (o1<o2)
                    return 1;
                else
                    return 0;
            }
        });

        System.out.println(numbers);


        // Сортировка собственных классов

        List<Person> people = new ArrayList<>();
        people.add(new Person(2,"Katy"));
        people.add(new Person(3,"Mike"));
        people.add(new Person(1,"Bob"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getId() > o2.getId())
                    return 1;
                else if (o1.getId()<o2.getId())
                    return -1;
                else
                    return 0;
            }
        });
        System.out.println(people);
    }


}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        /*  Конвенция
        Если o1 > o2 => return 1
        o1 < o2 => return -1
        o1 == o2 => return 0
         */

        if (o1.length()>o2.length())
            return 1;
        else if (o1.length()<o2.length())
            return -1;
        else
            return 0;
    }
}

// Сортировка по убыванию
class BackwardsIntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1>o2)
            return -1;
        else if (o1<o2)
            return 1;
        else
            return 0;
    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}