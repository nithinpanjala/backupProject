package com.foodmunch.Services;

import java.util.List;
import java.util.Set;

import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Entity.RestaurantAddress;

import com.foodmunch.Entity.FoodMenu;

import com.foodmunch.Entity.FoodMenu.FoodType;

public interface RestaurantServices {
	
	

	public Restaurant restaurantSignUp(Restaurant restaurant); // create
	public Restaurant readRestaurant(int restaurantId); // read
	public List<Restaurant> getAllRestaurants(); 	// read all restaurants
	public Restaurant updateRestaurant(Restaurant restaurant); // update
	public String deleteRestaurant(int restaurantId); // delete
	public Restaurant restaurantAddAddress(Restaurant restaurant, RestaurantAddress restaurantAddress);

	
	
	//Dishes 
	public List<FoodMenu> addDishes(FoodMenu dish) ;

	public FoodMenu UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, int restaurantId);

	public FoodMenu createDish(FoodMenu dish);

	public String deleteDish(int dishId);

	public FoodMenu updateDishQuantity(int quantity, int dishId);

	public FoodMenu readDish(int Dishid);
	
	public Set<FoodMenu> getAllDishes(int restaurantId);
	public Set<FoodMenu> getOnlyVeg(int restaurantId);
	public Set<FoodMenu> getOnlyNonVeg(int restaurantId);
}
