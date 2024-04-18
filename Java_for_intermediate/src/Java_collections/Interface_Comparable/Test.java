package Java_collections.Interface_Comparable;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();
//        Set<Person> peopleSet = new TreeSet<>();

        addElements(peopleList);
//        addElements(peopleSet);

        Collections.sort(peopleList);
        System.out.println(peopleList);
//        System.out.println(peopleSet);
    }

    private static void addElements(Collection collection){
       collection.add(new Person(1, "Bob"));
        collection.add(new Person(4, "George"));
        collection.add(new Person(3, "Katy"));
        collection.add(new Person(2, "Tom"));
    }
}

class Person implements Comparable<Person>{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Сравнение по длине имени
//    @Override
//    public int compareTo(Person o) {
//        if(this.name.length() > o.getName().length())
//            return 1;
//        else if(this.name.length() < o.getName().length())
//            return -1;
//        else
//            return 0;
//    }

    // Сортировка лексигографическая по имени
//    @Override
//    public int compareTo(Person o) {
//        return this.name.compareTo(o.getName());
//    }


    @Override
    public int compareTo(Person o) {
        return Integer.compare(id,o.getId());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

