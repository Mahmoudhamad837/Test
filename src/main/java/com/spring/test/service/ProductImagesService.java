package com.spring.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.entity.ProductImages;
import com.spring.test.repository.ProductImagesRepository;

@Service
public class ProductImagesService {

	@Autowired
	private ProductImagesRepository productImagesRepository;
	
	public List<ProductImages> save(List<ProductImages> productImages){
		List<ProductImages> products = new ArrayList<ProductImages>();
		for(ProductImages productImage: productImages) {
			products.add(productImagesRepository.save(productImage));
		}
		return products;
	}
	
	public List<ProductImages> findAll(){
		return productImagesRepository.findAll();
	}
	
	public List<ProductImages> getImagesforProduct(int id){
		return productImagesRepository.getImagesforProduct(id);
	}
}
