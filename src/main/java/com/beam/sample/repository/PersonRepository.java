package com.beam.sample.repository;

import com.beam.sample.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by x0r on 14/05/16.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByFirstName(String firstName);

    Person findByLastName(String lastName);

    Person findByIdAndFirstName(String id, String name);
}
