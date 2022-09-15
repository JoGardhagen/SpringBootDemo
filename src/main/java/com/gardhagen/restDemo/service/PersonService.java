package com.gardhagen.restDemo.service;

import com.gardhagen.restDemo.exception.ResourceNotFoundException;
import com.gardhagen.restDemo.model.Person;
import com.gardhagen.restDemo.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceInterface{

    @Autowired
    private PersonRepository personRepository;
        
    @Override
    public Person savePerson(Person person) {return personRepository.save(person);}

    @Override
    public List<Person> getAllPersons() {return personRepository.findAll();}

    @Override
    public Person getPersonById(int id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            return person.get();
        }else {
            throw new ResourceNotFoundException("Person","Id");

        }
    }

    @Override
    public Person updatePerson(Person person, int id) {
        Person p = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person","Id",id));
        p.setName(person.getName());
        p.setAge(person.getAge());
        p.setEmail(person.getEmail());
        personRepository.save(p);
        return p;
    }

    @Override
    public void deletePerson(int id) {
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person","Id",id));
        personRepository.deleteById(id);
    }

    @Override
    public boolean selectExistByEmail(String email) {
        return false;
    }


}
