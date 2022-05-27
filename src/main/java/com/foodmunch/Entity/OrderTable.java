package com.foodmunch.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordertable")
public class OrderTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderTableId;
	private long OrderCustId;
	private int orderRestId;
	private int orderFoodId;
	private int quantity;
	
	   @OneToOne(mappedBy = "orderTable")
		private Cart cart;
	
	public OrderTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderTableId() {
		return orderTableId;
	}
	public void setOrderTableId(int orderTableId) {
		this.orderTableId = orderTableId;
	}
	public long getOrderCustId() {
		return OrderCustId;
	}
	public void setOrderCustId(long orderCustId) {
		OrderCustId = orderCustId;
	}
	public int getOrderRestId() {
		return orderRestId;
	}
	public void setOrderRestId(int orderRestId) {
		this.orderRestId = orderRestId;
	}
	public int getOrderFoodId() {
		return orderFoodId;
	}
	public void setOrderFoodId(int orderFoodId) {
		this.orderFoodId = orderFoodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
