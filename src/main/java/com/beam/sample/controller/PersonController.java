package com.beam.sample.controller;

import com.beam.sample.business.PersonBS;
import com.beam.sample.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by x0r on 14/05/16.
 */
@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonBS personBS;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Person> listAll() {
        return personBS.listAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person findOne(@PathVariable("id") String id) {
        return personBS.findOne(id);
    }


    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Person findByName(@PathVariable("name") String name) {
        return personBS.findByName(name);
    }

    @RequestMapping(value = "both/{id}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Person findbyBoth(@PathVariable("id") String id, @PathVariable("name") String name) {
        return personBS.findByBoth(id, name);
    }

    @RequestMapping(value = "rp", method = RequestMethod.GET)
    @ResponseBody
    public Person person(@RequestParam("id") String id) {
        return personBS.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Person person(@RequestBody Person person) {
        return personBS.insert(person);
    }


}
