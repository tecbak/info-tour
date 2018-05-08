package ua.rud.infotour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.rud.infotour.domain.Person;
import ua.rud.infotour.repository.PersonRepository;
import ua.rud.infotour.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(String name) {
        Person person = new Person();
        person.setName(name);
        return personRepository.saveAndFlush(person);
    }

    @Override
    public Person getByName(String name) {
        Person person = personRepository.getByName(name);
        if (person == null) {
            throw new UsernameNotFoundException("Failed to find person with name " + name);
        }
        return person;
    }

}
