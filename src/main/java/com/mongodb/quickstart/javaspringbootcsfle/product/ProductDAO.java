package com.mongodb.quickstart.javaspringbootcsfle.product;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public Product addProduct(Product product) {
		return mongoTemplate.save(product);
	}
	
	public List<Product> findMaxProduct() {
		// Using Aggregation 
		MatchOperation matchOperation = Aggregation.match(Criteria.where("productName").is("Tablet"));
		TypedAggregation<Product> aggregation = Aggregation.newAggregation(Product.class,matchOperation);
		List<Product> product = mongoTemplate.aggregate(aggregation, Product.class).getMappedResults();
		
		// Using Query
		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("productName").regex("^"+Pattern.quote("c")+"$","i"));
//		List<Product> product = mongoTemplate.find(query, Product.class);
		return product;
	}
}
