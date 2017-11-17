package com.javadev.helloSpring;

import com.javadev.helloSpring.model.Person;
import com.javadev.helloSpring.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    PersonService personService = new PersonService();

    @RequestMapping(value = "/persons", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getPersons() {
        List listOfPersons = personService.getAllPersons();
        return listOfPersons;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST, headers = "Accept=application/json")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);

    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);

    }
}
