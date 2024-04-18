package spring.web.fin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.web.fin.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> { // Integer - type of PK
   // Кастомные запросы
    List<Person> findByName(String name);

    List<Person> findByNameOrderByAge(String name);

    List<Person> findByEmail(String email);

    List<Person> findByNameStartingWith(String startingWith);

    List<Person> findByNameOrEmail(String name, String email);
}
