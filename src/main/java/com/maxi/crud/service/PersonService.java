package com.maxi.crud.service;

import com.maxi.crud.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPeople();

    Person getPerson(Long id);

    void addPerson(Person person);

    void updatePerson(Long id, Person person);

    void deletePerson(Long id);
}
