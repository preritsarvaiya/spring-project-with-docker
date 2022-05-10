package com.example.demounittest.service;

import com.example.demounittest.entities.Person;
import com.example.demounittest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepo;

    @Override
    public ResponseEntity<Person> updateInfoOfPerson(Integer id, Person prsn) {
        Optional<Person> personData = personRepo.findById(id);
        if(personData.isPresent()) {
            Person p = personData.get();
            p.setPersonId(prsn.getPersonId());
            p.setPersonName(prsn.getPersonName());
            p.setPersonCity(prsn.getPersonCity());
            p.setPassword(prsn.getPassword());
            return new ResponseEntity<>(personRepo.save(p), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Person addPerson(Person personAdd) {
        return personRepo.save(personAdd);
    }

    @Override
    public List<Person> listPerson() {
        List<Person> personList = new ArrayList<>();
        personRepo.findAll().forEach(personList::add);
        return personList;
    }

    @Override
    public void deletePerson(int id) {
        personRepo.deleteById(id);
        return;
    }

    public PersonServiceImpl(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }
}
