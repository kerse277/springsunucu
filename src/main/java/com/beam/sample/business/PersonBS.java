package com.beam.sample.business;

import com.beam.sample.model.Person;
import com.beam.sample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by x0r on 14/05/16.
 */
@Service
public class PersonBS {

    @Autowired
    PersonRepository personRepository;

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person findOne(String id) {
        return personRepository.findOne(id);
    }

    public Person findByName(String name) {
        return personRepository.findByFirstName(name);
    }

    public Person findByBoth(String id, String name) {
        return personRepository.findByIdAndFirstName(id, name);
    }

    public Person insert(Person person) {
        person.setId(UUID.randomUUID().toString());
        person.setNew(true);
        person = personRepository.save(person);
        return person;
    }
}
