package com.dxc.personrestapi.controller;

import java.time.LocalDate;
import java.util.List;

import com.dxc.personrestapi.model.Person;
import com.dxc.personrestapi.repository.PersonRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PersonController {

    private final PersonRepository repository;

  PersonController(PersonRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/persons")
 public List<Person> all() {
    return repository.findAll();
  }

  @PostMapping("/persons")
public  Person newPerson(@RequestBody Person newPerson) {
  newPerson.setDob(LocalDate());
    return repository.save(newPerson);
  }

  private LocalDate LocalDate() {
    return null;
  }

  @GetMapping("/person/{id}")
 public Person one(@PathVariable Integer id) {

    return repository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
  }

  @PutMapping("/person/{id}")
  public Person replaceAuthor(@RequestBody Person newPerson, @PathVariable Integer id) {

    return repository.findById(id)
        .map(person -> {
          person.setName(newPerson.getName());
          person.setEmail(newPerson.getEmail());
          person.setDob(LocalDate.now());
          return repository.save(person);
        })
        .orElseGet(() -> {
          newPerson.setId(id);
          return repository.save(newPerson);
        });
  }

  @DeleteMapping("/person/{id}")
 public void deleteAuthor(@PathVariable Integer id) {
    repository.deleteById(id);
  }
} 