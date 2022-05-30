package com.foodmunch.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Services.CustomerAddressService;
import com.foodmunch.Services.CustomerService;
import com.foodmunch.Services.FoodMenuService;



@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerAddressService addressService;

	@Autowired
	FoodMenuService creditService;

//	@PostMapping("/signup")
//	public void save(@Valid @RequestBody Customer customer) {
//		customerService.save(customer);
//	}

	@PostMapping("/signup")
	public void memberRegistration(@Valid @RequestBody CustomerDTO customerData) {
		CustomerAddress addressObject = customerData.getAddress();
		//addressService.save(addressObject);

		Customer customerObject = customerData.getCustomer();
		customerObject.setAddress(addressObject);
		//customerService.save(customerData.getCustomer());

		CreditCard creditCardObject = customerData.getCreditCard();
		creditCardObject.setCardHolder(customerObject);
		creditService.save(creditCardObject);
	}
	@GetMapping(value = "/check-card/{customerId}")
    public CreditCard findCreditCard(@PathVariable long customerId) {
        return creditService.findByCardHolder(customerId);
    }

	@PutMapping
	public Customer update(@RequestBody Customer customer) {
		return customerService.update(customer);
	}

	@GetMapping
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public Customer findOne(@PathVariable Long id) {
		return customerService.findOne(id);
	}

}