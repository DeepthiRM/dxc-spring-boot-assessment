package com.dxc.personrestapi.service;

import java.util.List;
import com.dxc.personrestapi.model.Person;
import com.dxc.personrestapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {


   @Autowired
    private PersonRepository PersonRepository;

    @Override
    public Person createPerson(Person Person) {
        return PersonRepository.save(Person);
    }

    @Override
    public void deletePerson(int id) {
        Person person = getPersonById(id);
        PersonRepository.delete(person);
        
    }

    @Override
    public List<Person> getAllPersons() {
        
        return PersonRepository.findAll();
    }


    @Override
    public Person getPersonById(int id) {
        
        return PersonRepository.findById(id).orElseThrow();
    }


    @Override
    public Person updatePerson(Person Person) {
        
        return PersonRepository.save(Person);
    }

}