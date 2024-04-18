package spring.security.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.security.FirstSecurityApp.models.Person;
import spring.security.FirstSecurityApp.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByUsername(String name){
        return peopleRepository.findByUsername(name);
    }
}
