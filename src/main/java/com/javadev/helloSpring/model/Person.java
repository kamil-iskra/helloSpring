package com.javadev.helloSpring.model;

import org.springframework.context.annotation.Bean;

public class Person {
    private static int nextId = 0;

    private int id;
    private String firstName, lastName;

    public Person(){
        super();
    }

    public Person(String firstName, String lastName) {
        super();
        this.id = Person.nextId;
        this.firstName = firstName;
        this.lastName = lastName;

        Person.nextId++;
    }

    public int getId() {

        return id;
    }

    public void setId() {
        this.id = Person.nextId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

