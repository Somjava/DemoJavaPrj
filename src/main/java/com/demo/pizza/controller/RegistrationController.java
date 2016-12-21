package com.demo.pizza.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.pizza.domain.Customer;
import com.demo.pizza.domain.Order;
import com.demo.pizza.domain.Pizza;
import com.demo.pizza.domain.Topping;
import com.demo.pizza.service.CustomerService;
import com.demo.pizza.service.OrderService;

@Controller
public class RegistrationController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	
	//Welcome URL
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		
		
		model.addAttribute("customer",new Customer() );
		
		return "login";
	}

	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("customer") Customer customer,Model model) throws Exception{
		
		
		model.addAttribute("customer",new Customer() );
		
		return "register";
		
	}
	
	@RequestMapping(value= "/registerCustomer", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("customer") Customer customer,Model model,HttpServletRequest request) throws Exception{
		
		
		boolean flag = false;
		
		if(!customer.getCustId().equals("")){
			
			
			flag  = customerService.register(customer);
			
		}else{
			return "login";
		}
		if(flag){
			
			HttpSession httpSession = request.getSession();
			
			httpSession.setAttribute("customer", customer);
			
			return "registerComplete";
			
		}else{
			
			return "login";
		}
			
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("customer") Customer customer,Model model,HttpServletRequest request) throws Exception{
		
		
		boolean flag = false;
		
		if(!customer.getCustId().equals("")){
			
			flag  = customerService.authenticateUser(customer);
			
		}else{
			return "login";
		}
		if(flag){
			
			HttpSession httpSession = request.getSession();
			customer = customerService.getCustomerByID(customer);
			httpSession.setAttribute("customer", customer);
			
			List<Pizza> pizzas = orderService.getPizzaList();
			List<Topping> toppings = orderService.getToppingList();
			model.addAttribute("order", new Order());
			model.addAttribute("customer", customer);
			model.addAttribute("pizzas", pizzas);
			model.addAttribute("toppings", toppings);
			
			return "home";
			
		}else{
			return "login";
		}
		
	}
	
	@RequestMapping(value= "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception{
		
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "login";
		
	}
	
	
	

}
