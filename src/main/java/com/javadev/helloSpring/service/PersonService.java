package com.javadev.helloSpring.service;

import com.javadev.helloSpring.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonService {
    static HashMap<Integer,Person> personIdMap=getPersonIdMap();


    public PersonService() {
        super();

        if(personIdMap==null)
        {
            personIdMap=new HashMap<Integer,Person>();
            // Creating some objects of Country while initializing
            Person indiaCountry=new Person(1, "India","Lolo");
            Person chinaCountry=new Person(4, "China","Kolo");
            Person nepalCountry=new Person(3, "Nepal","Polo");
            Person bhutanCountry=new Person(2, "Bhutan","Zolo");


            personIdMap.put(1,indiaCountry);
            personIdMap.put(4,chinaCountry);
            personIdMap.put(3,nepalCountry);
            personIdMap.put(2,bhutanCountry);
        }
    }

    public List getAllPersons()
    {
        List persons = new ArrayList(personIdMap.values());
        return persons;
    }

    public Person getPerson(int id)
    {
        Person person= personIdMap.get(id);
        return person;
    }
    public Person addPerson(Person person)
    {
        person.setId(getMaxId()+1);
        personIdMap.put(person.getId(), person);
        return person;
    }

    public Person updatePerson(Person person)
    {
        if(person.getId()<=0)
            return null;
        personIdMap.put(person.getId(), person);
        return person;

    }
    public void deletePerson(int id)
    {
        personIdMap.remove(id);
    }

    public static HashMap<Integer, Person> getPersonIdMap() {
        return personIdMap;
    }

    // Utility method to get max id
    public static int getMaxId()
    { int max=0;
        for (int id:personIdMap.keySet()) {
            if(max<=id)
                max=id;

        }
        return max;
    }
}
