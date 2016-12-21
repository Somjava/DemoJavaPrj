package com.demo.pizza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topping_mst")
public class Topping {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="topping_id")
	private int toppingId; 
	
	@Column(name="topping_type")
	private String toppingType;
	
	@Column(name="topping_price")
	private double toppingPrice;
	
	@Column(name="pizza_id")
	private String pizzaId;

	/**
	 * @return the toppingId
	 */
	public int getToppingId() {
		return toppingId;
	}

	/**
	 * @param toppingId the toppingId to set
	 */
	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}

	/**
	 * @return the toppingType
	 */
	public String getToppingType() {
		return toppingType;
	}

	/**
	 * @param toppingType the toppingType to set
	 */
	public void setToppingType(String toppingType) {
		this.toppingType = toppingType;
	}

	/**
	 * @return the toppingPrice
	 */
	public double getToppingPrice() {
		return toppingPrice;
	}

	/**
	 * @param toppingPrice the toppingPrice to set
	 */
	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

	/**
	 * @return the pizzaId
	 */
	public String getPizzaId() {
		return pizzaId;
	}

	/**
	 * @param pizzaId the pizzaId to set
	 */
	public void setPizzaId(String pizzaId) {
		this.pizzaId = pizzaId;
	}

}
