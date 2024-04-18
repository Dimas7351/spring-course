package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Person") // Необязательно, так как название класса такое же, как и у таблицы
public class Person {

    @Id // Для первичного ключа
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // указываем, когда генерируется автоматически AS IDENTITY
//    @SequenceGenerator() // Если бы был Sequence
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Person(){}

    public Person(String name, int age) {
//        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
