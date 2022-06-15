package com.foodmunch.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;


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

	@JsonManagedReference(value = "customerAddress")
	@OneToMany(mappedBy = "customer", cascade = CascadeType.MERGE)
	private Set<CustomerAddress> customerAddresses;
	
	@JsonManagedReference(value = "cartConnection")
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL )
	private Set<Cart> cart;
	
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

	public Customer(long customerId, @NotEmpty(message = "Please provide a userName") String customerName,
			@NotEmpty(message = "Please provide a userPassword") String customerPassword,
			@NotEmpty(message = "Please provide a userfirstName") @Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15") String customerFirstName,
			@NotEmpty(message = "Please provide a userlastName") @Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15") String customerLastName,
			@NotEmpty(message = "Please provide a usermobile") @Size(min = 10, max = 10, message = "customerMobile must be 10 digits") String customerMobile,
			@NotEmpty(message = "Please provide a userEmail") @Email(message = "Enter a valid customer Email ID") String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
	}

	public Customer(long customerId, @NotEmpty(message = "Please provide a userName") String customerName,
			@NotEmpty(message = "Please provide a userPassword") String customerPassword,
			@NotEmpty(message = "Please provide a userfirstName") @Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15") String customerFirstName,
			@NotEmpty(message = "Please provide a userlastName") @Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15") String customerLastName,
			@NotEmpty(message = "Please provide a usermobile") @Size(min = 10, max = 10, message = "customerMobile must be 10 digits") String customerMobile,
			@NotEmpty(message = "Please provide a userEmail") @Email(message = "Enter a valid customer Email ID") String customerEmail,
			Set<CustomerAddress> customerAddresses) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddresses = customerAddresses;
	}

	public Set<CustomerAddress> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public Customer(long customerId, @NotEmpty(message = "Please provide a userName") String customerName,
			@NotEmpty(message = "Please provide a userPassword") String customerPassword,
			@NotEmpty(message = "Please provide a userfirstName") @Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15") String customerFirstName,
			@NotEmpty(message = "Please provide a userlastName") @Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15") String customerLastName,
			@NotEmpty(message = "Please provide a usermobile") @Size(min = 10, max = 10, message = "customerMobile must be 10 digits") String customerMobile,
			@NotEmpty(message = "Please provide a userEmail") @Email(message = "Enter a valid customer Email ID") String customerEmail,
			Set<CustomerAddress> customerAddresses, Set<Cart> cart) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddresses = customerAddresses;
		this.cart = cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	
}
