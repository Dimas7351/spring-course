package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Passport")
public class Passport implements Serializable { // Где есть сущности нестандартные (не int)

    // С Id для паспортов (Serializable не нужен)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Owning side
    // Без id для паспортов
//    @Id
//    @OneToOne
//    @JoinColumn(name = "person_id", referencedColumnName = "id")
//    private Person person;

    @Column(name = "passport_number")
    private int passportNumber;


    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Passport(){}

//    public Passport(Person person, int passportNumber) {
//        this.person = person;
//        this.passportNumber = passportNumber;
//    }


    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "person=" + person +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
