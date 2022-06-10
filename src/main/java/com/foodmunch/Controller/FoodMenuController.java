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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodmunch.Entity.FoodMenu;
import com.foodmunch.Services.RestaurantServices;

import springfox.documentation.spring.web.json.Json;


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
	public ResponseEntity<String> deleteDish(@PathVariable("dishId") int dishId) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String s = restaurantServices.deleteDish(dishId);
		return new ResponseEntity<String>(mapper.writeValueAsString(s), HttpStatus.OK);
	}

	/* *************************************************************************
	 *  						update operations
	 *	***********************************************************************
	 */
	@PutMapping(value = "/updateDishQuantity/{quantity}/{dishId}")
	public ResponseEntity<FoodMenu> updateDishQuantity(@PathVariable("quantity")  int quantity,@PathVariable("dishId") int dishId) {
		return new ResponseEntity<FoodMenu>(restaurantServices.updateDishQuantity(quantity, dishId), HttpStatus.OK);

	}
	/* *************************************************************************
	 *  						Read operations
	 *	***********************************************************************
	 */

	@GetMapping(value = "/readDish")
	public ResponseEntity<FoodMenu> readDish(@RequestParam int Dishid) {
		return new ResponseEntity<FoodMenu>(restaurantServices.readDish(Dishid), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllDishes")
	public ResponseEntity<Set<FoodMenu>> getAllDishes(@RequestParam int restaurantId) {
		return new ResponseEntity<Set<FoodMenu>>(restaurantServices.getAllDishes(restaurantId), HttpStatus.OK);
	}


}
