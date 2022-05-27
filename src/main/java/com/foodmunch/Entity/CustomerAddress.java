package com.foodmunch.Entity;

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
	
	@ManyToOne
	@JoinColumn(name = "customerId",referencedColumnName = "customerId" )
	@JsonBackReference(value = "customerAddress")
	private Customer customer;
	
	   @OneToOne(mappedBy = "deliveryAddress")
		private Cart cart;

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
