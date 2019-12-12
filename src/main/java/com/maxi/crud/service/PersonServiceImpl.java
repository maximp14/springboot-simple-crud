package com.maxi.crud.service;

import com.maxi.crud.model.Person;
import com.maxi.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPeople() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(id + "does not exist")
        );
    }

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Long id, Person person) {
        Person person1 = getPerson(id);
        if (person1 !=null) {
            person1.setName(person.getName());
            person1.setLastName(person.getLastName());
            person1.setAddress(person.getAddress());
            person1.setPhone(person.getPhone());
            personRepository.save(person1);
        }
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
