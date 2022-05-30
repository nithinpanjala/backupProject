package com.foodmunch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmunch.Entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer , Long> {

}
