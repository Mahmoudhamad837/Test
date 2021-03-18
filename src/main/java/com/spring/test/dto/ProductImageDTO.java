package com.spring.test.dto;

import java.util.List;

import com.spring.test.entity.Category;

public class ProductImageDTO {

	private String name;
	
	private String code;
	
	private String quantity;
	
	private String description;
	
	private Category category;
	
	private List<byte[]> image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<byte[]> getImage() {
		return image;
	}

	public void setImage(List<byte[]> image) {
		this.image = image;
	}
	
	
}
