package com.maxi.crud.controller;

import com.maxi.crud.model.Person;
import com.maxi.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") Long id){
        return personService.getPerson(id);
    }

    @PutMapping("/person/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person){
        personService.updatePerson(id, person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
    }


}
