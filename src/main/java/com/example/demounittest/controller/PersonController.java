package com.example.demounittest.controller;

import com.example.demounittest.entities.Person;
import com.example.demounittest.repository.PersonRepository;
import com.example.demounittest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepo;
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String names) {

        if(names == null) {
            List<Person> namesss = personService.listPerson();
            return new ResponseEntity<>(namesss, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getById(@PathVariable("id") int id) {

        Optional<Person> personId = personRepo.findById(id);
        if(personId != null) {
            return new ResponseEntity<>(personId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@RequestBody Person personAdd){
        try {
            Person result = personService.addPerson(personAdd);
            if(result == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.POST)
    public ResponseEntity<Person> updatePersonInfo(@PathVariable("id") Integer id, @RequestBody Person prsn) {
        if(id != null) {
            personService.updateInfoOfPerson(id, prsn);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/deletePerson/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") int id) {
        try {
            personService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}