package com.foodmunch.Services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmunch.Entity.FoodMenu;
import com.foodmunch.Entity.FoodMenu.FoodType;
import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Repository.FoodMenuRepository;
import com.foodmunch.Exceptions.CustomException;


@Service
@Transactional 
public class FoodMenuServiceImpl implements FoodMenuService{
	
	@Autowired
	FoodMenuRepository dishRepository;

	@Override
	public List<FoodMenu> addDishes(FoodMenu dish) {
		if (dishRepository.existsById(dish.getFoodId())) {
			throw new CustomException("dish already exists ");
	
		} else {
			 dishRepository.save(dish);
			 
		}
		

		return   dishRepository.findAll();
	}
	
	


	@Override
	public FoodMenu UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, Restaurant restaurant) throws CustomException {

		if (dishRepository.existsById(dishId)) {
			FoodMenu dish1 = new FoodMenu(dishId, dishName, dishPrice, dishQuantityAvailable, vegeterianType, restaurant);
			return dishRepository.save(dish1);
	
		} else {
			throw new CustomException("no dish found");
		}
	}

	@Override
	public FoodMenu createDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, Restaurant restaurant)  throws CustomException {
		if (dishRepository.existsById(dishId)) {
			throw new CustomException("dish already exists ");
	
		} else {
			FoodMenu dish = new FoodMenu(dishId, dishName, dishPrice, dishQuantityAvailable, vegeterianType, restaurant);
			return dishRepository.save(dish);
		}
		

	}

	@Override
	public FoodMenu deleteDish(int dishId)  throws CustomException {
		
		if (dishRepository.existsById(dishId)) {
			FoodMenu dish = dishRepository.getById(dishId);
			dishRepository.delete(dish);
			return dish;
	
		} else {
			throw new CustomException("dish does not exists ");
		}
	}

	@Override
	public FoodMenu updateDishQuantity(int quantity, int dishId)  throws CustomException {
		
		if (dishRepository.existsById(dishId)) {
			FoodMenu dish = dishRepository.getById(dishId);
			dish.setFoodQuantityAvailable(quantity);
			dishRepository.save(dish);
			return dish;
	
		} else {
			throw new CustomException("dish does not exists ");
		}

	}

	@Override
	public FoodMenu readDish(int dishId)  throws CustomException{
		
		if (dishRepository.existsById(dishId)) {
			return dishRepository.getById(dishId);
	
		} else {
			throw new CustomException("dish does not exists ");
	}
	}

	@Override
	public List<FoodMenu> readAllDishes() throws CustomException {
		if(dishRepository.findAll() == null) {
			throw new CustomException(" no dishes avaiable ");
		}else {
			return dishRepository.findAll();
		}
	}
	

}