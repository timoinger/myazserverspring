package com.example.demo;

import com.example.demo.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class MyazApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.demo.MyazApplication.class, args);
    }

    @GetMapping(value = "/peps")
    public List<Person> getAllPeople() {
        Person p = new Person(0, "ttttest");
        List<Person> list = new ArrayList<Person>();
        list.add(p);
        return list;
    }
}
