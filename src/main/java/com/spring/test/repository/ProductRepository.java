package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public long countByName(String name);
}
