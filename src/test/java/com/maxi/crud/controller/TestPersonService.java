package com.maxi.crud.controller;

import com.maxi.crud.model.Person;
import com.maxi.crud.repository.PersonRepository;
import com.maxi.crud.service.PersonServiceImpl;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
public class TestPersonService {

    Person person;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Before
    public void init(){
        initMocks(TestPersonService.class);
        person = new Person(1L,"Maxi","Pavolini","Baker Street 221","32153213");
    }

    @Test
    public void getPeopleTest(){
        List<Person> personList = new ArrayList<>();
        when(personRepository.findAll()).thenReturn(personList);
        List<Person> personList1 = personService.getPeople();
        assertTrue(personList.size() == personList1.size());
    }

    @Test
    public void givenIdReturnPerson(){
        when(personRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(person));
        Person person1 = personService.getPerson(anyLong());
        assertNotNull(person1);
        assertEquals("Maxi", person1.getName());

    }

    @Test
    public void givenIdReturnException(){
        when(personRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(null));
        assertThrows(NoSuchElementException.class,
            ()-> {
                personService.getPerson(anyLong());
            });
    }

    

}
