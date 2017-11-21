package com.javadev.helloSpring.service;

import com.javadev.helloSpring.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonService {
    static HashMap<Integer, Person> personIdMap = getPersonIdMap();

    public PersonService() {

        if (personIdMap == null) {
            personIdMap = new HashMap<Integer, Person>();
            Person adam = new Person("Adam", "Kowalski");
            Person tomasz = new Person("Tomasz", "Ziolo");
            Person grzegorz = new Person("Grzegorz", "Zwierzynski");
            Person dawid = new Person("Dawid", "Biganski");

            personIdMap.put(adam.getId(), adam);
            personIdMap.put(tomasz.getId(), tomasz);
            personIdMap.put(grzegorz.getId(), grzegorz);
            personIdMap.put(dawid.getId(), dawid);
        }
    }

    public List getAllPersons() {
        List persons = new ArrayList(personIdMap.values());
        return persons;
    }

    public Person getPerson(int id) {
        Person person = personIdMap.get(id);
        return person;
    }

    public Person addPerson(Person person) {
        person.setId();
        personIdMap.put(person.getId(), person);
        return person;
    }

    public Person updatePerson(Person person) {
        if(!personIdMap.containsKey(person.getId()))
            return null;

        personIdMap.put(person.getId(), person);
        return person;

    }

    public void deletePerson(int id) {
        personIdMap.remove(id);
    }

    public static HashMap<Integer, Person> getPersonIdMap() {
        return personIdMap;
    }
}
