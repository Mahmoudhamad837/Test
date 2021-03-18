package com.spring.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.entity.Order;
import com.spring.test.entity.UserData;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	public List<Order> getOrdersByAssignedDriver(UserData driver);

}
