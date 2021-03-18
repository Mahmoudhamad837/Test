package com.spring.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.test.entity.ProductImages;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Integer> {

	@Query(value="select * from product_image where product_id=?1", nativeQuery = true)
	public List<ProductImages> getImagesforProduct(int productId);
}
