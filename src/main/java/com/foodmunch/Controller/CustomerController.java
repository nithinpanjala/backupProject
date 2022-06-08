package com.foodmunch.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.foodmunch.Entity.Constants;
import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Services.CustomerAddressService;
import com.foodmunch.Services.CustomerService;
import com.foodmunch.Services.FoodMenuService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerAddressService addressService;

	@Autowired
	CustomerAddressService customerAddressService;


	/*
	 * *************************************************************************
	 *  create operations
	 * ***********************************************************************
	 */
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<Customer> createUser(@Valid @RequestBody Customer user) {

		return new ResponseEntity<Customer>(customerService.userSignUp(user), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/getUser/{userId}/{userPassword}")
	public ResponseEntity<Customer> readUser(@Valid @PathVariable("userId") long userId,
			@PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<Customer>(customerService.readUser(userId, userPassword), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<List<Customer>> readUser() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/readUserByUserNameAndPassword/{userName}/{userPassword}")
	public ResponseEntity<Customer> readUserByUserNameAndPassword(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<Customer>(customerService.readUserByUserNameAndPassword(userName, userPassword), HttpStatus.OK);

	}

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	

	@DeleteMapping(value = "/deleteUser/{userId}/{userPassword}")
	public ResponseEntity<String> deleteByUserIdAndUserPassword(@Valid @PathVariable("userId") long userId,@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String>(customerService.deleteByUserIdAndUserPassword(userId, userPassword), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByUserNameAndUserPassword/{userName}/{userPassword}")
	public ResponseEntity<String> deleteByUserName(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String> ( customerService.deleteByUserNameAndUserPassword(userName, userPassword), HttpStatus.OK);
	}



	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */


	@PutMapping(value = "/updateUser/{user}")
	public  ResponseEntity<Customer> updateUser(@Valid @RequestBody Customer user) {
		return new ResponseEntity<Customer>(customerService.updateUser(user), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/updateUserPassword/{userName}/{userPassword}/{newUserPassword}")
	public ResponseEntity<Customer> updateUserPassword(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUserPassword")String newUserPassword) {
		return new ResponseEntity<Customer>(customerService.updateUserPassword(userName, userPassword, newUserPassword), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUsermobile/{userName}/{userPassword}/{newUsermobile}")
	public ResponseEntity<Customer> updateUsermobile(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUsermobile") String newUsermobile) {
		return new ResponseEntity<Customer>(customerService.updateUsermobile(userName, userPassword, newUsermobile), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUserEmail/{userName}/{userPassword}/{newUserEmail}")
	public ResponseEntity<Customer> updateUserEmail(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUserEmail") String newUserEmail) {
		return new ResponseEntity<Customer>(customerService.updateUserEmail(userName, userPassword, newUserEmail), HttpStatus.ACCEPTED);
	}
	



	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	@PostMapping(value = "/authenticate")
	public Map<String, String> generateToken(@RequestBody Customer customer){
		long timestamp=System.currentTimeMillis();
		String token=Jwts.builder().signWith(SignatureAlgorithm.HS256,Constants.API_SECRET_KEY)
			.setIssuedAt(new Date(timestamp))
			.setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
			.claim("customerId", customer.getCustomerId())
			.claim("customerName", customer.getCustomerName())
			.claim("customerEmail", customer.getCustomerEmail())
			.compact();
		Map<String, String> map= new HashMap<>();
		
		map.put("JWT", token);
		return map;
		
	}

	
}