package com.dxc.personrestapi.service;

import java.util.List;
import com.dxc.personrestapi.model.Person;

public interface PersonService {

    public Person getPersonById(int Id);
    

    public Person createPerson(Person Person);

    public Person updatePerson(Person Person);

    public void deletePerson(int Id);

    public List<Person> getAllPersons();

    
}
