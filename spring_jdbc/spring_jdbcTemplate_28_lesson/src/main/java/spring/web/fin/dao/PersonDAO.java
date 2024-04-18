package spring.web.fin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring.web.fin.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Person> index(){
       return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class)); // Можно использовать вместо собственного RowMappera так как поля entity совпадают с названиями колонок в таблице
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null); //orElse(new Error("Человек не найден"))
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?,?)",person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), updatedPerson.getId());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);
    }
}
