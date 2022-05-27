package com.foodmunch.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "foodmenu")
public class FoodMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foodId", updatable = false, nullable = false)
	private int foodId;
	

	@Column(name = "foodName", nullable = false)
	private String foodName;
	
	
	@Column(name = "foodPrice", nullable = false)
	private float foodPrice;
	

	@Column(name = "foodQuantityAvailable", nullable = false)
	private int foodQuantityAvailable;
	

	@Column(name = "isVegeterian")
	private FoodType isVegeterian;
	public enum FoodType {
	    VEG, NONVEG  
	}
	
	@ManyToOne
	@JoinColumn(name = "restaurantId")
	@JsonBackReference(value = "foodMenu")
	private Restaurant restaurant;

	public FoodMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public float getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodQuantityAvailable() {
		return foodQuantityAvailable;
	}

	public void setFoodQuantityAvailable(int foodQuantityAvailable) {
		this.foodQuantityAvailable = foodQuantityAvailable;
	}

	public FoodType getIsVegeterian() {
		return isVegeterian;
	}

	public void setIsVegeterian(FoodType isVegeterian) {
		this.isVegeterian = isVegeterian;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
