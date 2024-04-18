package spring.web.fin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spring.web.fin.dao.PersonDAO;
import spring.web.fin.models.Person;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);  // Указываем класс для которого нужен валидатор
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // Нужно посмотреть, есть ли человек с тким же email'ом в БД
        // Без Optional
//        if(personDAO.show(person.getEmail()) != null){
//            errors.rejectValue("email", "", "This email is already taken");
//        }

        // С Optional в personDao
        if(personDAO.show(person.getEmail()).isPresent()){
            errors.rejectValue("email", "", "This email is already taken");
        }
    }
}
