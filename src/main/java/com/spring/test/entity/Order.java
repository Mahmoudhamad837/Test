package com.spring.test.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String orderStatus;
	
	private String paymentMethod;
	
	private double totalPrice;
	
	@OneToMany(mappedBy="orders")
	private List<OrderItems> orderItems;
	
	@ManyToOne()
	@JoinColumn(name = "user")
	private UserData user_id;
	
	@ManyToOne()
	@JoinColumn(name = "assignedDriver")
	private UserData assignedDriver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public UserData getUser_id() {
		return user_id;
	}

	public void setUser_id(UserData user_id) {
		this.user_id = user_id;
	}

	public UserData getAssignedDriver() {
		return assignedDriver;
	}

	public void setAssignedDriver(UserData assignedDriver) {
		this.assignedDriver = assignedDriver;
	}
}
