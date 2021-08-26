package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MyazApplication {

    private final PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(MyazApplication.class, args);
    }

    @Autowired
    public MyazApplication(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/people")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping("/peoples")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

}
