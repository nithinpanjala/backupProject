package com.foodmunch.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Address;
import com.stg.service.AddressService;



@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping
	public void save(@RequestBody Address address) {
		addressService.save(address);
	}

	@PutMapping
	public Address update(@RequestBody Address address) {
		return addressService.update(address);
	}

	@GetMapping
	public List<Address> findAll() {
		return addressService.findAll();
	}

	@GetMapping("/{id}")
	public Address findOne(@PathVariable int id) {
		return addressService.findOne(id);
	}
	
}