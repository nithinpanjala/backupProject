package com.foodmunch.Entity;


import com.foodmunch.Entity.FoodMenu.FoodType;

public class MenuDAO {
	
	private int foodId;
	private String foodName;
	private float foodPrice;
	private int foodQuantityAvailable;
	private FoodType isVegeterian;
	private int restaurantId;
	public MenuDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuDAO(int foodId, String foodName, float foodPrice, int foodQuantityAvailable, FoodType isVegeterian,
			int restaurantId) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantityAvailable = foodQuantityAvailable;
		this.isVegeterian = isVegeterian;
		this.restaurantId = restaurantId;
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
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
}
