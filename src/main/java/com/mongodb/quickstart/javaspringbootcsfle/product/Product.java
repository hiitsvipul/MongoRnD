package com.mongodb.quickstart.javaspringbootcsfle.product;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Encrypted;

@Document("product")
@Encrypted(keyId = "#{mongocrypt.keyId(#target)}")
public class Product {
	@Id
	private ObjectId id;
	@Encrypted(algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Deterministic")
	private String productName;
	@Encrypted(algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Deterministic")
	private int price;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}
	public Product() {
		
	}
	
	public Product(String productName, int price) {
		super();
		this.productName = productName;
		this.price = price;
	}
	public Product(ObjectId id, String productName, int price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}
	
	
}
