package com.mongodb.quickstart.javaspringbootcsfle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.quickstart.javaspringbootcsfle.dto.PersonDTO;
import com.mongodb.quickstart.javaspringbootcsfle.model.PersonEntity;

@Repository
class PersonDAOImpl implements PersonDAO{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<PersonEntity> findAllPersonEntity() {
		return mongoTemplate.findAll(PersonEntity.class, "persons");
	}

	@Override
	public List<PersonDTO> findAllPersonDTO() {
		return mongoTemplate.findAll(PersonDTO.class, "persons");
	}

	@Override
	public PersonEntity createPersonEntity(PersonEntity person) {
		// TODO Auto-generated method stub
		return mongoTemplate.save(person);
	}

	@Override
	public PersonDTO createPersonDTO(PersonDTO person) {
		return mongoTemplate.save(person);
	}

}
