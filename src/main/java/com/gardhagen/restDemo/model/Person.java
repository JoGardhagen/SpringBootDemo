package com.gardhagen.restDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name="age")
    private int age;
    @Column(name = "email")
    private String email;

    public Person(int personId, String name, int age, String email) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public Person() {}

    public int getPersonId() {return personId;}
    public void setPersonId(int personId) {this.personId = personId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

}
