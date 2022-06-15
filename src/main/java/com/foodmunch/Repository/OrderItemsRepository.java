package com.foodmunch.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodmunch.Entity.OrderItems;

public interface OrderItemsRepository   extends JpaRepository<OrderItems, Integer>{



	@Query(value = "SELECT * from order_items o where o.cart_no = ?1", nativeQuery = true)
	public List<OrderItems> findByCartNo(int cartNo);
}
