package com.foodmunch.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;




@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
	List<CustomerAddress> findAllByCustomer(Customer user);
	void deleteByCustomer(Customer user);
}
