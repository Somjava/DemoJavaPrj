package com.demo.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.pizza.domain.Order;
import com.demo.pizza.domain.Pizza;
import com.demo.pizza.domain.Topping;
import com.demo.pizza.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo orderRepo;
	
	
	@Transactional
	public boolean placeOrder(Order order) throws Exception {

		return orderRepo.placeOrder(order);
	}

	@Transactional
	public List<Pizza> getPizzaList() throws Exception {

		return orderRepo.getPizzaList();
	}

	
	@Transactional
	public List<Topping> getToppingList() throws Exception {

		return orderRepo.getToppingList();
	}


	@Transactional
	public List<Order> getOrderDetails(Order order) throws Exception {

		return orderRepo.getOrderDetails(order);
	}

	
}
