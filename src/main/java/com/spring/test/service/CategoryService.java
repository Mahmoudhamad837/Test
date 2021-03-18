package com.spring.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.entity.Category;
import com.spring.test.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category save(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category findById(int id) {
		Optional<Category> category = categoryRepo.findById(id);
		Category theCategory = null;
		if(category.isPresent()) {
			theCategory = category.get();
		}
		return theCategory;
	}
	
	public List<Category> findAllCategories(){
		return categoryRepo.findAll();
	}
	
	public Category deleteById(int id) {
		Category category = findById(id);
		categoryRepo.deleteById(id);
		return category;
	}
	
	public long getCountByName() {
		return categoryRepo.count();
	}
}
