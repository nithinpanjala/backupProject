package com.foodmunch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmunch.Entity.RestaurantAddress;

public interface RestaurantAddressrRepository extends JpaRepository<RestaurantAddress, Integer> {

}
