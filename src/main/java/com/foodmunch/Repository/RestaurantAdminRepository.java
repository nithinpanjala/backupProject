package com.foodmunch.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.foodmunch.Entity.RestaurantAdmin;

public interface RestaurantAdminRepository extends JpaRepository<RestaurantAdmin, Long> {

	void deleteByAdminIdAndAdminPassword(long userId,String userPassword);
	 void  deleteByAdminNameAndAdminPassword(String userName,String userPassword);
	 Optional<RestaurantAdmin>  findByAdminNameAndAdminPassword(String userName,String userPassword);
	 Optional<RestaurantAdmin>  findByAdminIdAndAdminPassword(long userId,String userPassword);

}
