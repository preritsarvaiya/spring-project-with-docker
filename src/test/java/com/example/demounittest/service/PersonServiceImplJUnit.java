package com.example.demounittest.service;

import com.example.demounittest.repository.PersonRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImplJUnit {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private PersonServiceImpl personService;

    @BeforeAll
    public void setup(){

    }


}