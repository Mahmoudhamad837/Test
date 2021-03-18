package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Long countByName(String name);
}
