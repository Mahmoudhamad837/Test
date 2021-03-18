package com.spring.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.entity.OrderItems;
import com.spring.test.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	public List<OrderItems> getAllOrderItems(){
		return orderItemsRepository.findAll();
	}
	
	public OrderItems getOrderItemsById(int id) {
		OrderItems theOrderItems = null;
		Optional<OrderItems> orderItems = orderItemsRepository.findById(id);
		if(orderItems.isPresent()) {
			theOrderItems = orderItems.get();
		}
		
		return theOrderItems;
	}
	
	public OrderItems save(OrderItems orderItems) {
		return orderItemsRepository.save(orderItems);
	}
	
	public OrderItems deleteById(int id) {
		OrderItems orderItems = getOrderItemsById(id);
		orderItemsRepository.deleteById(id);
		return orderItems;
	}
}
