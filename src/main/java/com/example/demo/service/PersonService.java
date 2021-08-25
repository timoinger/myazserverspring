package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("sql") PersonDao personDao) {
        this.personDao = personDao;
    }

    public void addPerson(Person person) {
        personDao.insertPerson(person.getName());
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(Integer id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(Integer id) {
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(Integer id, Person person) {
        return personDao.updatePersonById(id, person.getName());
    }
}
