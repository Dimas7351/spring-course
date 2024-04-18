package Reflexion.part2;

@Author(name = "Dima", dateOfCreation = 2024)
public class Person {
    private int id;
    private String name;

    public Person(){
        this.id=-1;
        this.name = "No name";
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Person with id: " + id + " and name: "+ name + " says hello!");

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
