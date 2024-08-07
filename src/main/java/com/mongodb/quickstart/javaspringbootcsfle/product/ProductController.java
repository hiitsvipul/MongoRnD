package com.mongodb.quickstart.javaspringbootcsfle.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductDAO productDao;
	
	@GetMapping("/getProductGreaterThan1000")
	public ResponseEntity<List<Product>> getProductGreaterThan1000(){
		List<Product> productList = productDao.findMaxProduct();
		return ResponseEntity.ok().body(productList);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product result = null;
		// make it "true" to generate random products
		boolean createRandomProducts = true;
		if(createRandomProducts) {
			String[] PRODUCT_NAMES = {
		            "Laptop", "Smartphone", "Tablet", "Smartwatch", "Headphones",
		            "Camera", "Printer", "Monitor", "Keyboard", "Mouse",
		            "Speaker", "Router", "Microphone", "Charger", "Projector",
		            "TV", "Drone", "Smart Home Hub", "VR Headset", "Fitness Tracker",
		            "Portable SSD", "External HDD", "USB Flash Drive", "Graphics Card",
		            "Processor", "Motherboard", "RAM", "Power Supply", "Cooling Fan", "Case"
		    };
			List<Product> products = new ArrayList<>();
	        Random random = new Random();

	        for(int i = 0; i < 30; i++) {
	            String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)];
	            int price = 50 + random.nextInt(950); // Random price between 50 and 999
	            products.add(new Product(productName, price));
	        }
	        
	        for(Product p : products) {
	        	result = productDao.addProduct(p);
	        }
		}
			else{
					result = productDao.addProduct(product);
				}
		
		return ResponseEntity.ok().body(result);
	} 
}
