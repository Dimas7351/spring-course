package Java_collections.Hashcode_equals;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();



        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);
    }
}

class Person{
    private int id;
    private String name;


    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "Person{ "+
                "id= " + id +
                ", name= " + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Person person = (Person) object;

        if (id != person.id) return false;
        return Objects.equals(name, person.name);
    }


    // {object} -> {int}
    // Если объекты разные, но хэши одинаковые, - это коллизия, так как кол-во hash-кодов ограничено
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /*
    Контракт hashcode() equals()

    1) У двух проверяемых объекто вызываем метод hashcode()
    если хэши разные -> два объекта точно разные

    2) если хэши одинаковые: -> equals()

    3) equals() выдает точный ответ
     */
}
