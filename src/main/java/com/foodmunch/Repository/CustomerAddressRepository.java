package com.foodmunch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodmunch.Entity.CustomerAddress;



@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

}
