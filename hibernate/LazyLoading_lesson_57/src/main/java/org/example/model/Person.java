package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // Каскадирование настраиваем в родительской Entity
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) // Чтобы можно было сохранять через save
    private List<Item> items;// так как у одного человека может быть несколько товаров

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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

    // Рефакторинг
    public void addItem(Item item){
        if(this.items == null)
            this.items = new ArrayList<>();

        this.items.add(item);
        item.setOwner(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
