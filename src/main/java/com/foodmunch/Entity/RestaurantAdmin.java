package com.foodmunch.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "restaurantadmin")
public class RestaurantAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adminId", updatable = false, nullable = false)
	private long adminId;

	@NotEmpty(message = "Please provide an admin Name")
	@Column(name = "adminName",unique = true, updatable = false, nullable = false)
	private String adminName;

	@NotEmpty(message = "Please provide an admin Password")
	@Column(name = "adminPassword", nullable = false)
	private String adminPassword;

	@NotEmpty(message = "Please provide an admin firstName")
	@Column(name = "adminFirstName", nullable = false)
	@Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15")
	private String adminFirstName;

	@NotEmpty(message = "Please provide an admin lastName")
	@Column(name = "adminLastName", nullable = false)
	@Size(min = 3, max = 15, message = "Customer First Name must be in the range of 3 and 15")
	private String adminLastName;

	@NotEmpty(message = "Please provide an admin mobile")
	@Column(name = "adminMobile", nullable = false)
	@Size(min = 10, max = 10, message = "customerMobile must be 10 digits")
	private String adminMobile;

	@NotEmpty(message = "Please provide an admin Email")
	@Email(message = "Enter a valid customer Email ID")
	@Column(name = "adminEmail", nullable = false)
	private String adminEmail;
	
	@ManyToOne
	@JoinColumn(name = "restaurantId")
	@JsonBackReference(value = "restaurantAdmin")
	private Restaurant restaurant;

	public RestaurantAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	
}
