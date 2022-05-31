package com.foodmunch.Controller;

import java.util.List;
import java.util.Set;

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

import com.foodmunch.Entity.FoodMenu;
import com.foodmunch.Services.RestaurantServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/FoodMenuOperations")
public class FoodMenuController {
	@Autowired
	RestaurantServices restaurantServices;
	
	/* *************************************************************************
	 *  						Dish operations
	 *	***********************************************************************
	 */
	
	
	/* *************************************************************************
	 *  						create  operations
	 *	***********************************************************************
	 */
	
	@PostMapping(value = "/addDishes/{dish}")
	public ResponseEntity<List<FoodMenu> > addDishes(@RequestBody FoodMenu dish ) {

		return new ResponseEntity<List<FoodMenu> >(restaurantServices.addDishes(dish), HttpStatus.OK);

	}
	
	/* *************************************************************************
	 *  						delete operations
	 *	***********************************************************************
	 */

	@DeleteMapping(value = "/deleteDish/{dishId}")
	public ResponseEntity<String> deleteDish(@PathVariable int dishId) {
		return new ResponseEntity<String>(restaurantServices.deleteDish(dishId), HttpStatus.FOUND);
	}

	/* *************************************************************************
	 *  						update operations
	 *	***********************************************************************
	 */
	@PutMapping(value = "/updateDishQuantity/{quantity}/{dishId}")
	public ResponseEntity<FoodMenu> updateDishQuantity(@RequestParam  int quantity,@RequestParam int dishId) {
		return new ResponseEntity<FoodMenu>(restaurantServices.updateDishQuantity(quantity, dishId), HttpStatus.ACCEPTED);

	}
	/* *************************************************************************
	 *  						Read operations
	 *	***********************************************************************
	 */

	@GetMapping(value = "/readDish/{Dishid}")
	public ResponseEntity<FoodMenu> readDish(@RequestParam int Dishid) {
		return new ResponseEntity<FoodMenu>(restaurantServices.readDish(Dishid), HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/getAllDishes/{restaurantId}")
	public ResponseEntity<Set<FoodMenu>> getAllDishes(@RequestParam int restaurantId) {
		return new ResponseEntity<Set<FoodMenu>>(restaurantServices.getAllDishes(restaurantId), HttpStatus.FOUND);
	}


}
