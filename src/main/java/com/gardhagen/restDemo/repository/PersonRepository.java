package com.gardhagen.restDemo.repository;

import com.gardhagen.restDemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    List<Person>findByNameOrderByAgeAsc(String name);
    List<Person>findByNameOrderByAgeDesc(String name);
}
