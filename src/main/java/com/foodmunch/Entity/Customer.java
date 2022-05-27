package com.foodmunch.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId", updatable = false, nullable = false)
	private long customerId;

	@NotEmpty(message = "Please provide a userName")
	@Column(name = "customerName",unique = true, updatable = false, nullable = false)
	private String customerName;

	@NotEmpty(message = "Please provide a userPassword")
	@Column(name = "customerPassword", nullable = false)
	private String customerPassword;

	@NotEmpty(message = "Please provide a userfirstName")
	@Column(name = "customerFirstName", nullable = false)
	@Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15")
	private String customerFirstName;

	@NotEmpty(message = "Please provide a userlastName")
	@Column(name = "customerLastName", nullable = false)
	@Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15")
	private String customerLastName;

	@NotEmpty(message = "Please provide a usermobile")
	@Column(name = "customerMobile", nullable = false)
	@Size(min = 10, max = 10, message = "customerMobile must be 10 digits")
	private String customerMobile;

	@NotEmpty(message = "Please provide a userEmail")
	@Email(message = "Enter a valid customer Email ID")
	@Column(name = "customerEmail", nullable = false)
	private String customerEmail;

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
}
