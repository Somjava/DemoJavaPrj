package com.demo.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.pizza.domain.Customer;
import com.demo.pizza.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;


	@Transactional
	public boolean register(Customer customer) throws Exception {

		return customerRepo.register(customer);
	}


	@Transactional
	public boolean authenticateUser(Customer customer) throws Exception {

		return customerRepo.authenticateUser(customer);
	}

	
	@Transactional
	public Customer getCustomerByID(Customer customer) throws Exception {

		return customerRepo.getCustomerByID(customer);
	}
	
	
}
