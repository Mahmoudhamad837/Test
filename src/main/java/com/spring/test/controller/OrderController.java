package com.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.Order;
import com.spring.test.entity.UserData;
import com.spring.test.service.OrderService;
import com.spring.test.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable("id")int id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping("/orders")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	@DeleteMapping("/orders/{id}")
	public Order deleteById(@PathVariable("id") int id) {
		return orderService.deleteById(id);
	}
	
	@GetMapping("/orders/driver/{driverId}")
	public List<Order> getOrdersByAssignedDriver(@PathVariable("driverId") int driverId){
		UserData driver = userService.findById(driverId);
		return orderService.getOrdersByAssignedDriver(driver);
	}

}
