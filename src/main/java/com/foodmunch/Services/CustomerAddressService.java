package com.foodmunch.Services;

import java.util.List;

import com.foodmunch.Entity.CustomerAddress;


public interface CustomerAddressService {
	public void save(CustomerAddress address);
	public CustomerAddress update(CustomerAddress address);
	public List<CustomerAddress> findAll();
	public CustomerAddress findOne(int id);
}
