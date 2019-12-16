package com.maxi.crud.controller;

import com.maxi.crud.model.Person;
import com.maxi.crud.repository.PersonRepository;
import com.maxi.crud.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class TestPersonService {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Before
    public void init(){
        initMocks(TestPersonService.class);
    }

    @Test
    public void getPeopleTest(){
        List<Person> personList = new ArrayList<>();
    }

}
