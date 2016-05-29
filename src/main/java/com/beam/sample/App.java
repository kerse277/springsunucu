package com.beam.sample;

import com.beam.sample.config.AppConfig;
import com.beam.sample.model.Person;
import com.beam.sample.repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Person person = new Person()
                .setFirstName("ali")
                .setLastName("veli");

        person.setId(UUID.randomUUID().toString());
        person.setNew(true);

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);

        personRepository.save(person);

    }
}
