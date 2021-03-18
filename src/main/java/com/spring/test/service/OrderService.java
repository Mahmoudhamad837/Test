package com.spring.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.entity.Order;
import com.spring.test.entity.UserData;
import com.spring.test.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order getOrderById(int id) {
		Order theOrder = null;
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			theOrder = order.get();
		}
		
		return theOrder;
	}
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	public Order deleteById(int id) {
		Order order = getOrderById(id);
		orderRepository.deleteById(id);
		return order;
	}
	
	public List<Order> getOrdersByAssignedDriver(UserData driver){
		return orderRepository.getOrdersByAssignedDriver(driver);
	}
}
