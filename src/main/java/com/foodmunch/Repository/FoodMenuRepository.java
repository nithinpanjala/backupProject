
  package com.foodmunch.Repository;
	/*  
	  import java.util.List;
	  
	  import org.springframework.data.jpa.repository.JpaRepository;
	  
	  import com.stg.entity.CreditCard; import com.stg.entity.Customer;
	  
	  public class FoodMenuRepository extends JpaRepository<CreditCard, Long> {
	  CreditCard findByCardHolder(long customerId); public List<CreditCard
	  >findAllMenuByResturantID(Long resturantId); }
	 */


import org.springframework.data.jpa.repository.JpaRepository;

import com.foodmunch.Entity.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {

}
