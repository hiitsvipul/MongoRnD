package com.mongodb.quickstart.javaspringbootcsfle.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {

	@Autowired
	MongoTemplate mongoTemplate;
}
