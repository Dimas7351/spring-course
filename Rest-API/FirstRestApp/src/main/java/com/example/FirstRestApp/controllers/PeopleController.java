package com.example.FirstRestApp.controllers;

import com.example.FirstRestApp.dto.PersonDTO;
import com.example.FirstRestApp.models.Person;
import com.example.FirstRestApp.services.PeopleService;
import com.example.FirstRestApp.util.PersonErrorResponse;
import com.example.FirstRestApp.util.PersonNotCreatedException;
import com.example.FirstRestApp.util.PersonNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final ModelMapper modelMapper;

    @Autowired
    public PeopleController(PeopleService peopleService,
                            ModelMapper modelMapper) {
        this.peopleService = peopleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<PersonDTO> getPeople(){
//        return peopleService.findAll(); // Jackson автоматически конвертирует объекты в JSON
        return peopleService.findAll().stream().map(this::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") int id){

//        return peopleService.findOne(id);
        return convertToPersonDTO(peopleService.findOne(id));

    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonDTO personDTO, // Person person
                                             BindingResult bindingResult){
       if (bindingResult.hasErrors()){
           StringBuilder errorMsg = new StringBuilder();

           List<FieldError> errors = bindingResult.getFieldErrors();
           for (FieldError error : errors){
               errorMsg.append(error.getField())
                       .append(" - ").append(error.getDefaultMessage())
                       .append(";");
           }

           throw new PersonNotCreatedException(errorMsg.toString());
       }

//       peopleService.save(person);
        peopleService.save(convertToPerson(personDTO));

       // Будет отправлен HTTP ответ с пустым телом и статусом 200
       return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e){
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this Id was not found!",
                System.currentTimeMillis()
        );

        // В HTTP ответе тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e){
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        // В HTTP ответе тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // 4**
    }

    private Person convertToPerson(PersonDTO personDTO){
//        ModelMapper mapper = new ModelMapper(); // Добавили в конструктор

       return modelMapper.map(personDTO, Person.class);

//        Person person = new Person();
//
//        person.setName(personDTO.getName());
//        person.setAge(personDTO.getAge());
//        person.setEmail(personDTO.getEmail());


//        return person;

    }

    private PersonDTO convertToPersonDTO(Person person){
        return modelMapper.map(person, PersonDTO.class);
    }

}
