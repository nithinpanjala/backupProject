package com.foodmunch.Entity;

import javax.persistence.CascadeType;
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
	
	@Column(name = "imageurl" ,length = 1999999999 )
	private byte[] imageurl;
	
	@Column(name = "isVegeterian")
	private FoodType isVegeterian;
	public enum FoodType {
	    VEG, NONVEG  
	}
	
	@ManyToOne(cascade = CascadeType.MERGE )
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

	public byte[] getImageurl() {
		return imageurl;
	}

	public void setImageurl(byte[] imageurl) {
		this.imageurl = imageurl;
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

	public void setIsVegeterian(FoodType foodType) {
		this.isVegeterian = foodType;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public FoodMenu(int foodId, String foodName, float foodPrice, int foodQuantityAvailable, FoodType isVegeterian,
			Restaurant restaurant) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantityAvailable = foodQuantityAvailable;
		this.isVegeterian = isVegeterian;
		this.restaurant = restaurant;
	}

	public FoodMenu(String foodName, float foodPrice, int foodQuantityAvailable, FoodType isVegeterian,
			Restaurant restaurant) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantityAvailable = foodQuantityAvailable;
		this.isVegeterian = isVegeterian;
		this.restaurant = restaurant;
	}

	public FoodMenu(int foodId, String foodName, float foodPrice, int foodQuantityAvailable, byte[] imageurl,
			FoodType isVegeterian, Restaurant restaurant) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantityAvailable = foodQuantityAvailable;
		this.imageurl = imageurl;
		this.isVegeterian = isVegeterian;
		this.restaurant = restaurant;
	}
	
	
}
