package com.foodmunch.Services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodmunch.Repository.RestaurantRepository;
import com.foodmunch.Repository.FoodMenuRepository;
import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Entity.RestaurantAddress;
import com.foodmunch.Entity.FoodMenu;
import com.foodmunch.Entity.FoodMenu.FoodType;

@Service
public class RestaurantServicesImpl implements RestaurantServices {

	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	FoodMenuRepository dishRepository;


	@Override
	public List<Restaurant> getAllRestaurants(){
		return restaurantRepository.findAll();

	}


	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant readRestaurant(int restaurantId) {
		return restaurantRepository.findById(restaurantId).get();
	}

	@Override
	public String deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		Restaurant restaurant= restaurantRepository.findById(restaurantId).get();
		if(restaurant == null) {
			return "invalid restaurant id";
		}
		else {
		restaurantRepository.delete(restaurant);
		return "Restaurant " + restaurant.getRestaurantName()+ " is deleted ";
		}
	}



	@Override
	public Restaurant restaurantSignUp(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	@Override
	public Restaurant restaurantAddAddress(Restaurant restaurant, RestaurantAddress restaurantAddress) {
			restaurant.setRestaurantAddress(restaurantAddress);
			return	restaurantRepository.save(restaurant);
	}


	@Override
	public List<FoodMenu> addDishes(FoodMenu dish) {
		dishRepository.save(dish);
		return dishRepository.findAll();
	}



	@Override
	public FoodMenu UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public FoodMenu createDish(FoodMenu dish) {
		return dishRepository.save(dish);
	
	}



	@Override
	public String deleteDish(int dishId) {
		dishRepository.delete(dishRepository.findById(dishId).get());
		String s = "dishID " + dishId+ "deleted";
		return s;
	}



	@Override
	public FoodMenu updateDishQuantity(int quantity, int dishId) {
		FoodMenu dish = dishRepository.findById(dishId).get();
		dish.setFoodQuantityAvailable(quantity);
		dishRepository.save(dish);
		return dish;
	}



	@Override
	public FoodMenu readDish(int dishId) {
		return dishRepository.findById(dishId).get();
	}
	
	@Override
	public Set<FoodMenu> getAllDishes(int restaurantId){
		Restaurant restaurant =  restaurantRepository.findById(restaurantId).get();
		return restaurant.getFoodMenu();
	}


	@Override
	public Set<FoodMenu> getOnlyVeg(int restaurantId) {
		Set<FoodMenu> set = restaurantRepository.findById(restaurantId).get().getFoodMenu();
		Set<FoodMenu> onlyVeg = set.stream().filter( x -> 
			 x.getIsVegeterian().name().contentEquals("VEG")
		).collect(Collectors.toSet());
		return onlyVeg;
	}
	
	@Override
	public Set<FoodMenu> getOnlyNonVeg(int restaurantId) {
		Set<FoodMenu> set = restaurantRepository.findById(restaurantId).get().getFoodMenu();
		Set<FoodMenu> 	onlyNonVeg = set.stream().filter( x -> 
			 x.getIsVegeterian().name().contentEquals("NONVEG")
		).collect(Collectors.toSet());
		return onlyNonVeg;
	}
}
