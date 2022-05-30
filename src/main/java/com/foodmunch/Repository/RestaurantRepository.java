package com.foodmunch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmunch.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
