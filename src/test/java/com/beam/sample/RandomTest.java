package com.beam.sample;

import com.beam.sample.config.AppConfig;
import com.beam.sample.model.Address;
import com.beam.sample.model.Person;
import com.beam.sample.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by x0r on 14/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class RandomTest {

    ObjectMapper objectMapper = new ObjectMapper();

    String id = UUID.randomUUID().toString();

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void before() {
        mongoTemplate.dropCollection(Person.class);
    }

    @Test
    public void testPerson() throws IOException {
        Person p = new Person()
                .setFirstName("Emre")
                .setLastName("Cakir")
                .setAddress(new Address()
                        .setStreet("Hakkibey Sokak")
                        .setCity("Samsun"));

        String str = objectMapper.writeValueAsString(p);

        Person h = objectMapper.readValue(str, Person.class);

        System.out.println(h.getFirstName());
    }

    @Test
    public void testPersonWrite() {

        Person p = new Person()
                .setFirstName("Selami")
                .setLastName("Sahin");

        p.setNew(true);
        p.setId(id);

        personRepository.save(p);
    }

    @Test
    public void testPersonRead() {
        testPersonWrite();

        Person p = personRepository.findOne(id);

        System.out.println(p.getFirstName());

        p.setLastName("Mustafa");

        personRepository.save(p);
    }

    @Test
    public void testPersonList() {
        testPersonWrite();

        List<Person> pList = personRepository.findAll();

        System.out.println(pList.size());
    }

    @Test
    public void testPersonWithAddress() {
        Person p = new Person()
                .setFirstName("Emre")
                .setLastName("Cakir")
                .setAddress(new Address()
                        .setStreet("Hakkibey Sokak")
                        .setCity("Samsun"));

        p.setId(UUID.randomUUID().toString());
        p.setNew(true);

        personRepository.save(p);
    }

    @Test
    public void testCustomMethods() {

        testPersonWrite();

        Person p1 = personRepository.findByFirstName("Selami");

        Person p2 = personRepository.findByLastName("Sahin");

        System.out.println(p1.equals(p2));

    }

    @Test
    public void testEquals() {

        testPersonWrite();

        Person p1 = personRepository.findByFirstName("Selami");

        Person p2 = personRepository.findByLastName("Sahin");

        System.out.println(1 == 2);

        System.out.println(1 == 1);

        System.out.println(true == true);

        System.out.println(p1.equals(p2));

        System.out.println(p1 == p2);

        String a = "string";

        String b = "string";


        System.out.println(a.equals(b));

        System.out.println(a == b);


    }


}
