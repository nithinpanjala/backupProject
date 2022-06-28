package com.foodmunch.Services;

import java.util.List;
import java.util.Set;

import com.foodmunch.Entity.FoodMenu;
import com.foodmunch.Entity.FoodMenu.FoodType;
import com.foodmunch.Exceptions.CustomException;
import com.foodmunch.Entity.Restaurant;

public interface FoodMenuService {
	public List<FoodMenu> addDishes(FoodMenu dish);

	public FoodMenu UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, Restaurant restaurant);

	public FoodMenu createDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, Restaurant restaurant);

	public FoodMenu deleteDish(int dishId);

	public FoodMenu updateDishQuantity(int quantity, int dishId);

	public FoodMenu readDish(int DishId);

	public List<FoodMenu> readAllDishes();
	public float getDishPrice(int itemId);

}
