package com.foodmunch.Entity;

import javax.persistence.Column;

public class CusAddDAO {

	private String custHouseNumber;
	private String custAddressLane1;
	private String custAddressLane2;
	private String custLandmark;
	private int custPincode;
	private String custDistrict;
	private String custState;
	private long customerId;
	public CusAddDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CusAddDAO(String custHouseNumber, String custAddressLane1, String custAddressLane2, String custLandmark,
			int custPincode, String custDistrict, String custState, long customerId) {
		super();
		this.custHouseNumber = custHouseNumber;
		this.custAddressLane1 = custAddressLane1;
		this.custAddressLane2 = custAddressLane2;
		this.custLandmark = custLandmark;
		this.custPincode = custPincode;
		this.custDistrict = custDistrict;
		this.custState = custState;
		this.customerId = customerId;
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
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
}
