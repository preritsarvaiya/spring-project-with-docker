package com.example.demounittest.repository;

import com.example.demounittest.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired PersonRepository personRepo;

    @Test
    void findByPersonId() {
        Person per = new Person(124, "Ganesh", "Surat", "Admin@321", (byte) 0);
        Person saved = personRepo.save(per);
        //Integer actualResult = personRepo.findByPersonId(124);
        //assertEquals(124, actualResult);
        assertThat(saved).isNotNull();
        assertThat(saved.getPersonId()).isGreaterThan(0);
    }

//    @Test
//    void findAllPersons(){
//        List<Person> personList = personRepo.findAll();
//
//        assertThat(personList).isNotNull();
//        assertThat(personList.size()).isEqualTo(3);
//    }
}