package com.foodmunch.Services;


import java.util.List;

import com.foodmunch.Entity.OrderItems;

public interface OrderTableService {

	public OrderItems CreateOrderItems(OrderItems orderItem);

	public OrderItems UpdateOrderItems(OrderItems orderItem);

	public String deleteOrderItems(int orderItemsId);

	public OrderItems readOrderItems(int orderItemsId);
	
	public List<OrderItems> readAllOrderItemsByCartNo(int cartNo);
}
