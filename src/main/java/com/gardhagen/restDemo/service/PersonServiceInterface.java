package com.gardhagen.restDemo.service;

import com.gardhagen.restDemo.model.Person;

import java.util.List;

public interface PersonServiceInterface {
    Person savePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(int id);
    Person updatePerson(Person person,int id);
    void deletePerson(int id);
    boolean selectExistByEmail(String email);
}
