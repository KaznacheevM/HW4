package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonService personService;

    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getPeoplePage(Model model) {
        List<Person> people = personService.getAllPeople();
        model.addAttribute("people", people);
        return "people";
    }

    @PostMapping
    public String addUser(Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }
}
