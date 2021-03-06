package com.demo.pizza.service;

import java.util.List;

import com.demo.pizza.domain.Order;
import com.demo.pizza.domain.Pizza;
import com.demo.pizza.domain.Topping;

public interface OrderService {

	public boolean placeOrder(Order order) throws Exception;
	
	public List<Pizza> getPizzaList() throws Exception;
	
	public List<Topping> getToppingList() throws Exception;
	
	public List<Order> getOrderDetails(Order order) throws Exception;
} 
