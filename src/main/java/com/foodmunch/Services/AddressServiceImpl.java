package com.foodmunch.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Repository.CustomerAddressRepository;


@Service
@Transactional 
public class AddressServiceImpl implements CustomerAddressService{


	@Autowired
	CustomerAddressRepository addressDao;

	@Override
	public void save(CustomerAddress address) {
		addressDao.save(address);
	}

	@Override
	public CustomerAddress update(CustomerAddress address) {
		return addressDao.save(address);
	}

	@Override
	public List<CustomerAddress> findAll() {
		return addressDao.findAll();
	}

	@Override
	public CustomerAddress findOne(int id) {
		return addressDao.findById(id).get();
	}

}
