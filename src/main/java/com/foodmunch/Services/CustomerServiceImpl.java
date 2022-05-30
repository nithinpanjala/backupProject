package com.foodmunch.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Repository.CustomerRepository;



@Service
@Transactional 
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerDao;

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	public Customer findOne(Long id) {
		return customerDao.findById(id).get();
	}

}