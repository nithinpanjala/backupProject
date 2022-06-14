package com.foodmunch.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmunch.Entity.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {


}
