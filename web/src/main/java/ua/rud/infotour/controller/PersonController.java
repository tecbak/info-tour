package ua.rud.infotour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.rud.infotour.domain.Person;
import ua.rud.infotour.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "add/{name}", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@PathVariable("name") String name) {
        Person person = personService.addPerson(name);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
