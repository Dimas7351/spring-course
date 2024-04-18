package spring.web.fin.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.web.fin.models.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1(){
        Session session = entityManager.unwrap(Session.class);

//        // 1 запрос
//        List<Person> people = session.createQuery("select p from Person p", Person.class)
//                .getResultList();
//
//        // N запросов к БД
//        for (Person person : people)
//            System.out.println("Person " + person.getName() + " has: " + person.getItems());

        // Solution
        // SQL: A LEFT JOIN B -> Результирующая объединенная таблица
        Set<Person> people = new HashSet<Person>(session.createQuery("select p from Person p LEFT JOIN FETCH p.items")
                .getResultList());  // Для set нужно реализовать hashcode и equals, либо сделать только через List, а не Set

        // N запросов к уже имеющемуся people, а не к БД
        for (Person person : people)
            System.out.println("Person " + person.getName() + " has: " + person.getItems());

    }
}
