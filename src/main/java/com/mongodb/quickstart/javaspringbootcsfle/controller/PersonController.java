package com.mongodb.quickstart.javaspringbootcsfle.controller;

import com.mongodb.quickstart.javaspringbootcsfle.csfleServiceImpl.MasterKeyServiceImpl;
import com.mongodb.quickstart.javaspringbootcsfle.dao.PersonDAO;
import com.mongodb.quickstart.javaspringbootcsfle.dto.PersonDTO;
import com.mongodb.quickstart.javaspringbootcsfle.exception.EntityNotFoundException;
import com.mongodb.quickstart.javaspringbootcsfle.model.PersonEntity;
import com.mongodb.quickstart.javaspringbootcsfle.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API for the persons.
 */
@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterKeyServiceImpl.class);
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @Autowired
    PersonDAO personDAO;

    @GetMapping("/persons")
    public List<PersonEntity> getAllPersons() {
    	return personDAO.findAllPersonEntity();
        //return personService.findAll();
    }

  @PostMapping("/person")
  @ResponseStatus(HttpStatus.CREATED)
  public PersonEntity createPerson(@RequestBody PersonEntity personDTO) {
      return personDAO.createPersonEntity(personDTO); 
  }
//    @PostMapping("/person")
//    @ResponseStatus(HttpStatus.CREATED)
//    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
//        return personService.save(personDTO);
//    }

    @GetMapping("/person/ssn/{ssn}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findBySsn(@PathVariable String ssn) {
        return personService.findBySsn(ssn);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MongoDB didn't find any document.")
    public final void handleNotFoundExceptions(EntityNotFoundException e) {
        LOGGER.info("=> Person not found: {}", e.toString());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public final void handleAllExceptions(RuntimeException e) {
        LOGGER.error("=> Internal server error.", e);
    }
}
