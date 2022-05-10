package com.example.demounittest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    //@GeneratedValue
    private Integer personId;
    private String personName;
    private String personCity;
    private String password;
    private Byte recordDeleted = 0;

    public Person(Integer personId, String personName, String personCity, String password, Byte recordDeleted) {
        this.personId = personId;
        this.personName = personName;
        this.personCity = personCity;
        this.password = password;
        this.recordDeleted = recordDeleted;
    }

    public Person() {

    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String personCity) {
        this.personCity = personCity;
    }

    public Byte getRecordDeleted() {
        return recordDeleted;
    }

    public void setRecordDeleted(Byte recordDeleted) {
        this.recordDeleted = recordDeleted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
