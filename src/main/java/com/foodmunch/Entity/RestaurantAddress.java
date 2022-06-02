package com.foodmunch.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
@Table(name = "restaurantaddress")
public class RestaurantAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurantAddressId", updatable = false, nullable = false)
	private int restaurantAddressId;


	@Column(name = "restaurantBuildingNumber", nullable = false)
	private String restaurantBuildingNumber;

	@Column(name = "addressLane1", nullable = false)
	private String restaurantAddressLane1;
	
	
	@Column(name = "addressLane2" ,nullable = false)
	private String restaurantAddressLane2;
	

	@Column(name = "landmark", nullable = false)
	private String restaurantLandmark;
	
	@Column(name = "pincode", nullable = false ,length = 6)
	private int restaurantPincode;
	
	@Column(name = "district", nullable = false)
	private String restaurantDistrict;
	
	@Column(name = "state", nullable = false)
	private String restaurantState;
	
    @OneToOne
    @JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId")
    @JsonBackReference 
    private Restaurant restaurant;

	public RestaurantAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRestaurantAddressId() {
		return restaurantAddressId;
	}

	public void setRestaurantAddressId(int restaurantAddressId) {
		this.restaurantAddressId = restaurantAddressId;
	}

	public String getRestaurantBuildingNumber() {
		return restaurantBuildingNumber;
	}

	public void setRestaurantBuildingNumber(String restaurantBuildingNumber) {
		this.restaurantBuildingNumber = restaurantBuildingNumber;
	}

	public String getRestaurantAddressLane1() {
		return restaurantAddressLane1;
	}

	public void setRestaurantAddressLane1(String restaurantAddressLane1) {
		this.restaurantAddressLane1 = restaurantAddressLane1;
	}

	public String getRestaurantAddressLane2() {
		return restaurantAddressLane2;
	}

	public void setRestaurantAddressLane2(String restaurantAddressLane2) {
		this.restaurantAddressLane2 = restaurantAddressLane2;
	}

	public String getRestaurantLandmark() {
		return restaurantLandmark;
	}

	public void setRestaurantLandmark(String restaurantLandmark) {
		this.restaurantLandmark = restaurantLandmark;
	}

	public int getRestaurantPincode() {
		return restaurantPincode;
	}

	public void setRestaurantPincode(int restaurantPincode) {
		this.restaurantPincode = restaurantPincode;
	}

	public String getRestaurantDistrict() {
		return restaurantDistrict;
	}

	public void setRestaurantDistrict(String restaurantDistrict) {
		this.restaurantDistrict = restaurantDistrict;
	}

	public String getRestaurantState() {
		return restaurantState;
	}

	public void setRestaurantState(String restaurantState) {
		this.restaurantState = restaurantState;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
    
}
