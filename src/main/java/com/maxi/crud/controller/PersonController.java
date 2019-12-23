package com.maxi.crud.controller;

import com.maxi.crud.model.Person;
import com.maxi.crud.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value = "Get all Persons",
    notes = "Get persons with all attributes",
    response = Person.class)

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPeople(){
        logger.info("This is an info message");
        return ResponseEntity.ok(personService.getPeople());
    }

    @ApiOperation(value = "Add a person",
        notes = "provide all attributes for adding a person",
        response = Person.class)
    @PostMapping("/person")
    public void addPerson(@RequestBody Person person){
        logger.info("This is an info message");
        personService.addPerson(person);
    }

    @ApiOperation(value = "Get person by ID",
        notes = "provide an id to look up for specific person",
        response = Person.class)
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id){
        logger.info("This is an info message");
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @ApiOperation(value = "Update person by ID",
        notes = "provide an id and attributes for update a person",
        response = Person.class)
    @PutMapping("/person/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person){
        logger.info("This is an info message");
        personService.updatePerson(id, person);
    }

    @ApiOperation(value = "Delete person by ID",
        notes = "provide an id to delete a person",
        response = Person.class)
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        logger.info("This is an info message");
        personService.deletePerson(id);
    }


}
