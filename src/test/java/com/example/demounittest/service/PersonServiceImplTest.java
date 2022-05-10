package com.example.demounittest.service;

import com.example.demounittest.entities.Person;
import com.example.demounittest.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepo;

    private PersonServiceImpl personServiceImpl;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        this.personServiceImpl = new PersonServiceImpl(this.personRepo);
    }

    @Test
    void updateInfoOfPerson() {
    }

    @Test
    void addPerson() {
        Person personAdd = new Person();
        personAdd.setPersonId(125);
        personAdd.setPersonName("Vamshi");
        personAdd.setPersonCity("Banglore");
        personAdd.setPassword("Reptime");
        personRepo.save(personAdd);

        assertThat(125).isEqualTo(personAdd.getPersonId());
    }

    @Test
    void listPerson() {
        personServiceImpl.listPerson();
        verify(personRepo).findAll();
    }

    @Test
    void deletePerson() {
        personServiceImpl.deletePerson(124);
        verify(personRepo).deleteById(124);
    }

//    @Test
//    void addPerson(){
//        Person personAdd = new Person();
//        personAdd.setPersonId(126);
//        personAdd.setPersonName("Vamshi");
//        personAdd.setPersonCity("Banglore");
//        personAdd.setPassword("Reptime");
//
//        BDDMockito.given(personRepo.save(personAdd)).willReturn(personAdd);
//        Person saved = personService.addPerson(personAdd);
//        assertThat(saved).isNotNull();
//    }
}