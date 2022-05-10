package com.example.demounittest.service;

import com.example.demounittest.entities.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    ResponseEntity<Person> updateInfoOfPerson(Integer id, Person prsn);

    Person addPerson(Person personAdd);

    List<Person> listPerson();

    void deletePerson(int id);
}
