package com.spring.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.entity.Product;
import com.spring.test.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public Product findProductById(int id) {
		Product theProduct = null;
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			theProduct = product.get();
		}
		
		return theProduct;
	}
	
	public Product deleteProductById(int id) {
		Product product = findProductById(id);
		productRepository.deleteById(id);
		
		return product;
	}
	
	public long getProductCount() {
		return productRepository.count();
	}
}
