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

import com.spring.test.entity.Category;
import com.spring.test.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public List<Category> getAllCategories(){
		return categoryService.findAllCategories();
	}
	
	@GetMapping("/category/{id}")
	public Category findById(@PathVariable("id")int id) {
		return categoryService.findById(id);
	}
	
	@PostMapping("/category")
	public Category save(@RequestBody Category category) {
		return categoryService.save(category);
	}
	
	@DeleteMapping("/category/{id}")
	public Category deleteById(@PathVariable int id) {
		return categoryService.deleteById(id);
	}
	
	@GetMapping("/category/count")
	public long getCategoryCount() {
		return categoryService.getCountByName();
	}

}
