package com.gardhagen.restDemo.controller;

import com.gardhagen.restDemo.model.Person;
import com.gardhagen.restDemo.repository.PersonRepository;
import com.gardhagen.restDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/saveperson")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);
    }
    @GetMapping("/getpersons")
    public List<Person> getAllPersons(){return personService.getAllPersons();}

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id")int id){
        return new ResponseEntity<Person>(personService.getPersonById(id),HttpStatus.OK);
    }
    @PutMapping("/updateperson/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id")int id,@RequestBody Person person){
        return new ResponseEntity<Person>(personService.updatePerson(person,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id")int id){
        personService.deletePerson(id);
        return new ResponseEntity<String>("Person deleted",HttpStatus.OK);
    }
    @GetMapping("/sortpersonsasc")
    public List<Person>sortPersons(){
        return personRepository.findByNameOrderByAgeAsc("");
    }
    @GetMapping("/sortpersonsdesc")
    public List<Person>sortPersons2(){
        return personRepository.findByNameOrderByAgeDesc("");
    }
}
