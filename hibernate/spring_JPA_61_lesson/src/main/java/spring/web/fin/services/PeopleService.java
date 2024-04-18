package spring.web.fin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.web.fin.models.Mood;
import spring.web.fin.models.Person;
import spring.web.fin.repositories.PeopleRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) // all public methods - transactional
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
        Optional<Person> foundPerson =  peopleRepository.findById(id);

        return foundPerson.orElse(null);
    }

    @Transactional // так как не readOnly=true
    public void save(Person person){
        person.setCreatedAt(new Date());
        person.setMood(Mood.CALM); //4
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson); // save также используется для update, так как Id уже существует в таблице и обновится значение
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }

    public void test(){
        System.out.println("Testing here with debug. Inside Hibernate Transaction");
    }

}
