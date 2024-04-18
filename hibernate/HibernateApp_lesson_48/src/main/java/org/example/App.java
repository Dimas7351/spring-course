package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = session.get(Person.class, 1);
//
//            System.out.println(person.getName());
//            System.out.println(person.getAge());

//            Person person1 = new Person("Test1",30);
            Person person2 = new Person("Test2",54);
//            Person person3 = new Person("Test3",12);
//
//            session.save(person1);
            session.persist(person2); // save - depricated
//            session.save(person3);

//            Person person = session.get(Person.class, 2);
//            person.setName("New name");

//            session.remove(person); // delete - depricated
            System.out.println(person2.getId());
            session.getTransaction().commit();
        } finally {

            sessionFactory.close();
        }

    }
}
