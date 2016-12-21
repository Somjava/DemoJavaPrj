package com.demo.pizza.service;

import com.demo.pizza.domain.Customer;

public interface CustomerService {
	
	 public boolean register(Customer customer) throws Exception;
	 
	 public boolean authenticateUser(Customer customer) throws Exception;

	 public Customer getCustomerByID(Customer customer) throws Exception ;
}
