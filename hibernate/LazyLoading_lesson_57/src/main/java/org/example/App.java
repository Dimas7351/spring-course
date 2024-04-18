package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Item item = session.get(Item.class,1);
//            System.out.println("Получили товар");
//
//            // Не делается select, так как уже была eager загрузка
//            System.out.println(item.getOwner());

            Person person = session.get(Person.class,1);
            System.out.println("Получили человека");

            // Получим связанные сущности (Lazy)
//            System.out.println(person.getItems());
//            Hibernate.initialize(person.getItems()); // подгружаем связанные сущности, чтобы не делать sout ** просто person.getItems() не присвоенный не сработает

            session.getTransaction().commit();
            // session.close()
            System.out.println("Вне сессии");
            // Вне сессии можно получать товары, так как была Eager загрузка
//            System.out.println(person.getItems());


            // Открываем сессию и транзакцию еще раз
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Внутри второй транзакции");

            // (объект person из предыдущей сессии еще не связан)
            person = (Person) session.merge(person);

            // HQL
            List<Item> items = session.createQuery("select i from Item i where i.owner.id=:personId", Item.class)
                            .setParameter("personId", person.getId()).getResultList();

            System.out.println(items);
//            Hibernate.initialize(person.getItems());

            session.getTransaction().commit();

            System.out.println("Вне второй сессии");

            // Это работает, так как связанные товары были загружены
            System.out.println(person.getItems());
        } finally {

            sessionFactory.close();
        }

    }
}
