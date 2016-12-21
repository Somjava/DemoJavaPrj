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
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.pizza.domain.Customer;
import com.demo.pizza.domain.Order;
import com.demo.pizza.domain.Pizza;
import com.demo.pizza.domain.Topping;
import com.demo.pizza.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value= "/makeOrder", method = RequestMethod.POST)
	public String makeOrder(@ModelAttribute("order") Order order,Model model,HttpServletRequest request) throws Exception{
		
		order.setPizzaId(0);
		boolean flag = orderService.placeOrder(order);
		if(flag){
			List<Pizza> pizzas = orderService.getPizzaList();
			List<Topping> toppings = orderService.getToppingList();
			model.addAttribute("order", new Order());
			HttpSession httpSession = request.getSession();
			
			Customer customer = (Customer) httpSession.getAttribute("customer");
			model.addAttribute("customer", customer);
			model.addAttribute("pizzas", pizzas);
			model.addAttribute("toppings", toppings);
			return "viewOrder";
		}else{
			
			List<Pizza> pizzas = orderService.getPizzaList();
			List<Topping> toppings = orderService.getToppingList();
			model.addAttribute("order", new Order());
			HttpSession httpSession = request.getSession();
			
			Customer customer = (Customer) httpSession.getAttribute("customer");
			model.addAttribute("customer", customer);
			model.addAttribute("pizzas", pizzas);
			model.addAttribute("toppings", toppings);
			return "home";
		}
		
	
	}
	@RequestMapping(value= "/viewOrder", method = RequestMethod.POST)
	public String viewOrder(@RequestParam("orderId") String orderId,Model model,HttpServletRequest request) throws Exception{
		
		HttpSession httpSession = request.getSession();
		Customer customer = (Customer) httpSession.getAttribute("customer");
		model.addAttribute("customer", customer);
		Order order = new Order();
		order.setOrderNo(orderId);
		List<Order> list = orderService.getOrderDetails(order);
		if(list!=null){
			model.addAttribute("order",list.get(0));
		}
		
		return "viewOrder";
	}
}
