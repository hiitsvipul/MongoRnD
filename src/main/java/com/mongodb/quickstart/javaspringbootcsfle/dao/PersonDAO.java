package com.mongodb.quickstart.javaspringbootcsfle.dao;

import java.util.List;

import com.mongodb.quickstart.javaspringbootcsfle.dto.PersonDTO;
import com.mongodb.quickstart.javaspringbootcsfle.model.PersonEntity;

public interface PersonDAO {
	public List<PersonEntity> findAllPersonEntity();
	public List<PersonDTO> findAllPersonDTO();
	public PersonEntity createPersonEntity(PersonEntity person);
	public PersonDTO createPersonDTO(PersonDTO person);
}
