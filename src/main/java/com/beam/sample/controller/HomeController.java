package com.beam.sample.controller;

import com.beam.sample.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by x0r on 14/05/16.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "osman", method = RequestMethod.GET)
    @ResponseBody
    public Person person() {
        return new Person()
                .setFirstName("osman")
                .setLastName("osman");
    }

}
