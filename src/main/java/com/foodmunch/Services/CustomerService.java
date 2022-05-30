package com.foodmunch.Services;

import java.util.List;

import com.foodmunch.Entity.Customer;


public interface CustomerService {
	public void save(Customer customer);
	public Customer update(Customer customer);
	public List<Customer> findAll();
	public Customer findOne(Long id);
}
