package com.dxc.personrestapi.controller;

public class PersonNotFoundException extends RuntimeException {

    PersonNotFoundException(Integer id) {
        super("Could not find Person " + id);
    
    
}
}