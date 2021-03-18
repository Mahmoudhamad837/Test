package com.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.ProductImages;
import com.spring.test.service.ProductImagesService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ProductImagesController {

	@Autowired
	private ProductImagesService productImagesService;
	
	@GetMapping("/productImages")
	public List<ProductImages> getAllProducts(){
		return productImagesService.findAll();
	}
	
	@GetMapping("/productImages/{id}")
	public List<ProductImages> findProductImagesByProductId(@PathVariable("id")int id) {
		return productImagesService.getImagesforProduct(id);
	}
	
	@PostMapping("/productImages")
	public List<ProductImages> save(@RequestBody List<ProductImages> products) {
		return productImagesService.save(products);
	}

}
