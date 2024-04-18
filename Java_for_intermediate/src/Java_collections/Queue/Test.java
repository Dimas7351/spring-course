package Java_collections.Queue;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        // FIFO
//        Queue<Person> people = new LinkedList<>();
//        people.add(person3);
//        people.add(person2);
//        people.add(person4);
//        people.add(person1);
//
//        // person3 <- person2 <- person4 <- person1
//        for(Person person : people){
//            System.out.println(person);
//        }

        // FIFO
        Queue<Person> people = new ArrayBlockingQueue<>(3); // Указываем максимальный размер очереди

        // add - throws exception
//        people.add(person3);
//        people.add(person2);
//        people.add(person4);
//        people.add(person1);

        //!!! alt+j - выделение нескольких строк
        // offer - не выбрасывает исключение, а выдает true/false
        System.out.println(people.offer(person3));
        System.out.println(people.offer(person2));
        System.out.println(people.offer(person4));
        System.out.println(people.offer(person1));
//
//        System.out.println(people.remove()); // Удаляет первый элемент в очереди
//        System.out.println(people.peek()); // Просмотр первого элемента в очереди, не удаляя его
//        System.out.println(people);
    }
}

class Person{
    private int id;

    public Person(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
