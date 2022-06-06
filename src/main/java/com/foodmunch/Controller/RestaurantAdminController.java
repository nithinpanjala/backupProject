package com.foodmunch.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.foodmunch.Entity.RestaurantAdmin;
import com.foodmunch.Services.RestaurantAdminService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/restaurantAdmin")
public class RestaurantAdminController {


	@Autowired
	RestaurantAdminService restaurantAdminService;
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<RestaurantAdmin> createUser(@Valid @RequestBody RestaurantAdmin user) {

		return new ResponseEntity<RestaurantAdmin>(restaurantAdminService.userSignUp(user), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/getUser/{userId}/{userPassword}")
	public ResponseEntity<RestaurantAdmin> readUser(@Valid @PathVariable("userId") long userId,
			@PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<RestaurantAdmin>(restaurantAdminService.readUser(userId, userPassword), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<List<RestaurantAdmin>> readUser() {
		return new ResponseEntity<List<RestaurantAdmin>>(restaurantAdminService.getAllCustomers(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/readUserByUserNameAndPassword/{userName}/{userPassword}")
	public ResponseEntity<RestaurantAdmin> readUserByUserNameAndPassword(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<RestaurantAdmin>(restaurantAdminService.readUserByUserNameAndPassword(userName, userPassword), HttpStatus.OK);

	}

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	

	@DeleteMapping(value = "/deleteUser/{userId}/{userPassword}")
	public ResponseEntity<String> deleteByUserIdAndUserPassword(@Valid @PathVariable("userId") long userId,@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String>(restaurantAdminService.deleteByUserIdAndUserPassword(userId, userPassword), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByUserNameAndUserPassword/{userName}/{userPassword}")
	public ResponseEntity<String> deleteByUserName(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String> ( restaurantAdminService.deleteByUserNameAndUserPassword(userName, userPassword), HttpStatus.OK);
	}



	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */


	@PutMapping(value = "/updateUser/{user}")
	public  ResponseEntity<RestaurantAdmin> updateUser(@Valid @RequestBody RestaurantAdmin user) {
		return new ResponseEntity<RestaurantAdmin>(restaurantAdminService.updateUser(user), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/updateUserPassword/{userName}/{userPassword}/{newUserPassword}")
	public ResponseEntity<RestaurantAdmin> updateUserPassword(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUserPassword")String newUserPassword) {
		return new ResponseEntity<RestaurantAdmin>(restaurantAdminService.updateUserPassword(userName, userPassword, newUserPassword), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUsermobile/{userName}/{userPassword}/{newUsermobile}")
	public ResponseEntity<RestaurantAdmin> updateUsermobile(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUsermobile") String newUsermobile) {
		return new ResponseEntity<RestaurantAdmin>(restaurantAdminService.updateUsermobile(userName, userPassword, newUsermobile), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUserEmail/{userName}/{userPassword}/{newUserEmail}")
	public ResponseEntity<RestaurantAdmin> updateUserEmail(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUserEmail") String newUserEmail) {
		return new ResponseEntity<RestaurantAdmin>(restaurantAdminService.updateUserEmail(userName, userPassword, newUserEmail), HttpStatus.ACCEPTED);
	}
	
	
}
