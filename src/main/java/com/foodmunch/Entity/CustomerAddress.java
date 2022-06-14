package com.foodmunch.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "customerAddress")
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custAddressId", updatable = false, nullable = false)
	private int custAddressId;
	

	@Column(name = "custhouseNumber", nullable = false)
	private String custHouseNumber;

	@Column(name = "custaddressLane1", nullable = false)
	private String custAddressLane1;
	
	
	@Column(name = "custaddressLane2" ,nullable = false)
	private String custAddressLane2;
	

	@Column(name = "custlandmark", nullable = false)
	private String custLandmark;
	
	@Column(name = "pincode", nullable = false ,length = 6)
	private int custPincode;
	
	@Column(name = "custdistrict", nullable = false)
	private String custDistrict;
	
	@Column(name = "custstate", nullable = false)
	private String custState;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerId",referencedColumnName = "customerId" )
	@JsonBackReference(value = "customerAddress")
	private Customer customer;
	
	   @OneToOne(mappedBy = "deliveryAddress",cascade = CascadeType.ALL)
		private Cart cart;

	public CustomerAddress(int custAddressId, String custHouseNumber, String custAddressLane1, String custAddressLane2,
			String custLandmark, int custPincode, String custDistrict, String custState, Customer customer) {
		super();
		this.custAddressId = custAddressId;
		this.custHouseNumber = custHouseNumber;
		this.custAddressLane1 = custAddressLane1;
		this.custAddressLane2 = custAddressLane2;
		this.custLandmark = custLandmark;
		this.custPincode = custPincode;
		this.custDistrict = custDistrict;
		this.custState = custState;
		this.customer = customer;
	}

	public CustomerAddress(int custAddressId, String custHouseNumber, String custAddressLane1, String custAddressLane2,
			String custLandmark, int custPincode, String custDistrict, String custState, Customer customer, Cart cart) {
		super();
		this.custAddressId = custAddressId;
		this.custHouseNumber = custHouseNumber;
		this.custAddressLane1 = custAddressLane1;
		this.custAddressLane2 = custAddressLane2;
		this.custLandmark = custLandmark;
		this.custPincode = custPincode;
		this.custDistrict = custDistrict;
		this.custState = custState;
		this.customer = customer;
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustAddressId() {
		return custAddressId;
	}

	public void setCustAddressId(int custAddressId) {
		this.custAddressId = custAddressId;
	}

	public String getCustHouseNumber() {
		return custHouseNumber;
	}

	public void setCustHouseNumber(String custHouseNumber) {
		this.custHouseNumber = custHouseNumber;
	}

	public String getCustAddressLane1() {
		return custAddressLane1;
	}

	public void setCustAddressLane1(String custAddressLane1) {
		this.custAddressLane1 = custAddressLane1;
	}

	public String getCustAddressLane2() {
		return custAddressLane2;
	}

	public void setCustAddressLane2(String custAddressLane2) {
		this.custAddressLane2 = custAddressLane2;
	}

	public String getCustLandmark() {
		return custLandmark;
	}

	public void setCustLandmark(String custLandmark) {
		this.custLandmark = custLandmark;
	}

	public int getCustPincode() {
		return custPincode;
	}

	public void setCustPincode(int custPincode) {
		this.custPincode = custPincode;
	}

	public String getCustDistrict() {
		return custDistrict;
	}

	public void setCustDistrict(String custDistrict) {
		this.custDistrict = custDistrict;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}
	
	
}
