package com.demo.pizza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Order_details")
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="orderId")
	private int orderId;
	
	private String orderNo;
	
	private int custId;
	
	private int pizzaId;
	
	private String orderStatus;

	private int shipmentCharge;

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the custId
	 */
	public int getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(int custId) {
		this.custId = custId;
	}

	/**
	 * @return the pizzaId
	 */
	public int getPizzaId() {
		return pizzaId;
	}

	/**
	 * @param pizzaId the pizzaId to set
	 */
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the shipmentCharge
	 */
	public int getShipmentCharge() {
		return shipmentCharge;
	}

	/**
	 * @param shipmentCharge the shipmentCharge to set
	 */
	public void setShipmentCharge(int shipmentCharge) {
		this.shipmentCharge = shipmentCharge;
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	

}
