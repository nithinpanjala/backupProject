package com.foodmunch.Controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.FoodMenu;
import com.foodmunch.Services.RestaurantServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/RestaurantOperations")
public class RestaurantController {

	@Autowired
	RestaurantServices restaurantServices;

	/*
	 *  Restaurant create operations
	 */
	
	@PostMapping(value = "/createRestaurant/{restaurant}")
	public  ResponseEntity<Restaurant > createRestaurant(@Valid @RequestBody Restaurant restaurant) {
		Restaurant restaurant1= restaurantServices.restaurantSignUp(restaurant);
		return new ResponseEntity<Restaurant >(restaurant1, HttpStatus.CREATED);

	}

	

	/*
	 *  Restaurant read operations
	 */

	@GetMapping(value = "/getRestaurant/{restaurantId}")
	public ResponseEntity<Restaurant > readRestaurant(@PathVariable("restaurantId") int restaurantId) {
		return new ResponseEntity<Restaurant >(restaurantServices.readRestaurant(restaurantId), HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/getAllRestaurant")
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		return new ResponseEntity<List<Restaurant>>(restaurantServices.getAllRestaurants(), HttpStatus.ACCEPTED);
	}
	
	/*
	 *  Restaurant update operations
	 */

	@PutMapping(value = "/updateRestaurant/{restaurant}")
	public ResponseEntity<Restaurant > updateRestaurant(@Valid @RequestBody Restaurant restaurant) {
		return new ResponseEntity<Restaurant >( restaurantServices.updateRestaurant(restaurant), HttpStatus.OK);

	}

	/*
	 *  Restaurant delete operations
	 */
	/*
	 *  Restaurant delete operations
	 */
	@DeleteMapping(value = "/deleteRestaurant/{restaurantId}")
	public ResponseEntity<String>  deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {

		return new ResponseEntity<String >(restaurantServices.deleteRestaurant(restaurantId), HttpStatus.OK);

	
	}
	
	
	
}
