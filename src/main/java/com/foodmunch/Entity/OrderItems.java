package com.foodmunch.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "OrderItems")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemsId;
	
	private int orderCustId;
	private int orderRestId;
	private int orderFoodId;
	private int quantity;
	
		@ManyToOne( cascade = CascadeType.ALL )
		@JsonBackReference(value = "orderTable")
		@JoinColumn(name = "cartNo",referencedColumnName = "cartNo" )
		private Cart cart;

		public OrderItems() {
			super();
			// TODO Auto-generated constructor stub
		}

		public OrderItems(int orderItemsId, int orderCustId, int orderRestId, int orderFoodId, int quantity,
				Cart cart) {
			super();
			this.orderItemsId = orderItemsId;
			this.orderCustId = orderCustId;
			this.orderRestId = orderRestId;
			this.orderFoodId = orderFoodId;
			this.quantity = quantity;
			this.cart = cart;
		}

		public OrderItems(int orderItemsId, int orderCustId, int orderRestId, int orderFoodId, int quantity) {
			super();
			this.orderItemsId = orderItemsId;
			this.orderCustId = orderCustId;
			this.orderRestId = orderRestId;
			this.orderFoodId = orderFoodId;
			this.quantity = quantity;
		}

		public int getOrderItemsId() {
			return orderItemsId;
		}

		public void setOrderItemsId(int orderItemsId) {
			this.orderItemsId = orderItemsId;
		}

		public int getOrderCustId() {
			return orderCustId;
		}

		public void setOrderCustId(int orderCustId) {
			this.orderCustId = orderCustId;
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

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

}
