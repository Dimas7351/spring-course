package spring.security.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.FirstSecurityApp.models.Person;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
        Optional<Person> findByUsername(String username);
}

