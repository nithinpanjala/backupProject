package com.foodmunch.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmunch.Entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer , Long> {

	void deleteByCustomerIdAndCustomerPassword(long userId,String userPassword);
	 void  deleteByCustomerNameAndCustomerPassword(String userName,String userPassword);
	 Optional<Customer>  findByCustomerNameAndCustomerPassword(String userName,String userPassword);
	 Optional<Customer>  findByCustomerIdAndCustomerPassword(long userId,String userPassword);

}
