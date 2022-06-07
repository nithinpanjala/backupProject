package com.foodmunch.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartNo", updatable = false, nullable = false)
	private int cartNo;

	@Column(name = "totalPrice")
	private float totalPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custAddressId", referencedColumnName = "custAddressId")
	private CustomerAddress deliveryAddress;
	
	@JsonManagedReference(value = "orderTable")
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private Set<OrderItems> orderItems;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartNo, float totalPrice, CustomerAddress deliveryAddress, Set<OrderItems> orderItems) {
		super();
		this.cartNo = cartNo;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
		this.orderItems = orderItems;
	}

	public Cart(int cartNo, float totalPrice, CustomerAddress deliveryAddress) {
		super();
		this.cartNo = cartNo;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CustomerAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(CustomerAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	

}
