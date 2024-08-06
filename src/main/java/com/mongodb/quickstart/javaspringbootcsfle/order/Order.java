package com.mongodb.quickstart.javaspringbootcsfle.order;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Encrypted;

import com.mongodb.quickstart.javaspringbootcsfle.product.Product;

@Document("product")
@Encrypted(keyId = "#{mongocrypt.keyId(#target)}")
public class Order {
	@Id
	private ObjectId id;
    private List<Product> products;
    
    @Encrypted(algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Deterministic")
    private double totalAmount;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", products=" + products + ", totalAmount=" + totalAmount + "]";
	}

	public Order() {
		
	}
	
	public Order(ObjectId id, List<Product> products, double totalAmount) {
		super();
		this.id = id;
		this.products = products;
		this.totalAmount = totalAmount;
	}
    
    
}
