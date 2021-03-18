package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.entity.Copoun;

@Repository
public interface CopounRepository extends JpaRepository<Copoun, Integer> {

	public Copoun getCopounByCopounName(String name);
}
