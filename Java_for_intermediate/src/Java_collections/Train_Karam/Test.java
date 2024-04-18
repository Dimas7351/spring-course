package Java_collections.Train_Karam;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Person> peopleList = new ArrayList<Person>();
        Set<Person> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(peopleSet);
    }
    private static void addElements(Collection collection){
        collection.add(new Person(2,"murhaf"));
        collection.add(new Person(3,"anas"));
        collection.add(new Person(4,"dima"));
        collection.add(new Person(1,"karam"));
    }
}
class Person implements Comparable<Person>{
    private int id;
    private String name;

    @Override
    public String toString() {
        return "person{" +
                "age=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if (this.id > o.getId()){
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        }else {
            return 0;
        }
    }
}