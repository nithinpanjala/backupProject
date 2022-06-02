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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Entity.RestaurantAddress;
import com.foodmunch.Services.RestaurantAddressService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/RestaurantAddress")
public class RestaurantAddressController {


	@Autowired
	RestaurantAddressService addressService;

	
	@PostMapping(value = "/addAddress/{address}")
	public ResponseEntity<Restaurant> addAddress(@Valid @RequestBody RestaurantAddress address) {

		return new ResponseEntity<Restaurant>(addressService.addAddress(address), HttpStatus.ACCEPTED);

	}
	@PostMapping(value = "/addRestaurantAddress")
	public ResponseEntity<Restaurant> addUserAddress( @RequestParam String houseNumber, @RequestParam String addressLane1,@RequestParam String addressLane2, @RequestParam String landmark,
			 @RequestParam int pincode, @RequestParam String district, @RequestParam String state, @RequestParam int restaurantId) {

		return new ResponseEntity<Restaurant>(addressService.addRestaurantAddress(   houseNumber,  addressLane1,  addressLane2,  landmark,
				 pincode,  district,  state,  restaurantId), HttpStatus.ACCEPTED);

	}
	
	
	@GetMapping(value = "/getSelectedAddress/{addressId}")
	public ResponseEntity<RestaurantAddress> getSelectedAddress(@PathVariable("addressId") int addressId) {

		return new ResponseEntity<RestaurantAddress>(addressService.getSelectedAddress(addressId), HttpStatus.ACCEPTED);

	}

	
	
	
	@DeleteMapping(value = "/deleteAddressByRestaurantId/{userId}/{userPassword}")
	public ResponseEntity<String> deleteAddressByUserId(@Valid @PathVariable long userId ,@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String> ( addressService.deleteAddressByRestaurantId(userId, userPassword), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAddressByID/{addressId}")
	public ResponseEntity<String> deleteAddressByID(@Valid @PathVariable("addressId") int addressId) {
		return new ResponseEntity<String> ( addressService.deleteAddressById(addressId), HttpStatus.OK);
	}
	
	
	

	@PutMapping(value = "/updateAddress/{address}")
	public  ResponseEntity<RestaurantAddress> updateUser(@Valid @RequestBody RestaurantAddress address) {
		return new ResponseEntity<RestaurantAddress>(addressService.updateAddress(address), HttpStatus.ACCEPTED);

	}
	
	
	@PutMapping(value = "/updateLandmark")
	public ResponseEntity<RestaurantAddress> updateUserEmail(@Valid @RequestParam int addressId,@Valid  @RequestParam String landmark) {
		return new ResponseEntity<RestaurantAddress>(addressService.updateLandmark(addressId, landmark), HttpStatus.ACCEPTED);
	}
	


	@PutMapping(value = "/updateHouseNoAndStreet")
	public ResponseEntity<RestaurantAddress> updateHouseNoAndStreet(@Valid @RequestParam int addressId,@Valid  @RequestParam String houseNumber,@Valid @RequestParam String addressLane1) {
		return new ResponseEntity<RestaurantAddress>(addressService.updateHouseNoAndStreet(addressId, houseNumber,addressLane1), HttpStatus.ACCEPTED);
	}
	




	
}