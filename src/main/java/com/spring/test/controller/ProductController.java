package com.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.Product;
import com.spring.test.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productService.findAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable("id")int id) {
		return productService.findProductById(id);
	}
	
	@PostMapping("/products")
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@DeleteMapping("/products/{id}")
	public Product deleteProductById(@PathVariable("id") int id) {
		return productService.deleteProductById(id);
	}
	
	@GetMapping("/products/count")
	public long getCountByName() {
		return productService.getProductCount();
	}
}
