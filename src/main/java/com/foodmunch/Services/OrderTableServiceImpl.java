package com.foodmunch.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodmunch.Entity.OrderItems;
import com.foodmunch.Repository.OrderItemsRepository;

@Service
@Transactional 
public class OrderTableServiceImpl implements OrderTableService{
	
	@Autowired
	OrderItemsRepository itemsRepository;
	
	@Override
	public OrderItems CreateOrderItems(OrderItems orderItem) {
		// TODO Auto-generated method stub
		return itemsRepository.save(orderItem);
	}

	@Override
	public OrderItems UpdateOrderItems(OrderItems orderItem) {
		// TODO Auto-generated method stub
		return  itemsRepository.save(orderItem);
	}

	@Override
	public String deleteOrderItems(int orderItemsId) {
		itemsRepository.deleteById(orderItemsId);
			return "orderItemsId Deleted";
	}

	@Override
	public OrderItems readOrderItems(int orderItemsId) {
		return itemsRepository.findById(orderItemsId).get();
	}

	@Override
	public List<OrderItems> readAllOrderItemsByCartNo(int cartNo) {
		// TODO Auto-generated method stub
		return itemsRepository.findByCartNo(cartNo);
	}

}
