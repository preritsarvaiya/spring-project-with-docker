package com.example.demounittest.repository;

import com.example.demounittest.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT person_id FROM person WHERE person_id = :person_id", nativeQuery = true)
    Integer findByPersonId(Integer person_id);
}
