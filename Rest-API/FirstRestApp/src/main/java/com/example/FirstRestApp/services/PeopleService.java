package com.example.FirstRestApp.services;

import com.example.FirstRestApp.models.Person;
import com.example.FirstRestApp.repositories.PeopleRepository;
import com.example.FirstRestApp.util.PersonNotFoundException;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        return peopleRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @Transactional
    public void save(Person person){
        enrichPerson(person);
        peopleRepository.save(person);
    }

    private void enrichPerson(Person person){
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        person.setCreatedWho("ADMIN");
    }

}
