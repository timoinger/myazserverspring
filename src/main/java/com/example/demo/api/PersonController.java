package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CORS Cross-Origin Port 3000 (React), 4200 (Angular), 8080 (Vue)

@RequestMapping
@RestController
public class PersonController {

	private final PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(PersonController.class, args);
	}

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
//	@CrossOrigin
	public void addPerson( @RequestBody Person person) {
		personService.addPerson(person);
	}

	@GetMapping
//	@CrossOrigin
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping(path = "{id}")
//	@CrossOrigin
	public Person getPersonById(@PathVariable("id") Integer id) {
		return personService.getPersonById(id).orElse(null);
	}

	@DeleteMapping(path = "{id}")
//	@CrossOrigin
	public int deletePersonById(@PathVariable("id") Integer id) {
		return personService.deletePerson(id);
	}

	@PutMapping(path = "{id}")
//	@CrossOrigin
	public int updatePersonById(@PathVariable("id") Integer id, @RequestBody Person personToUpdate) {
		return personService.updatePersonById(id, personToUpdate);
	}
}
