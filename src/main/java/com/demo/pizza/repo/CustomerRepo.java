package com.demo.pizza.repo;

import com.demo.pizza.domain.Customer;

public interface CustomerRepo {

	
	public boolean register(Customer customer) throws Exception;
	 
	public boolean authenticateUser(Customer customer) throws Exception;
	
	public Customer getCustomerByID(Customer customer) throws Exception ;
}
