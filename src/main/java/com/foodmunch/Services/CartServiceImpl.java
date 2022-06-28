package com.foodmunch.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodmunch.Entity.Cart;
import com.foodmunch.Entity.OrderItems;
import com.foodmunch.Repository.CartRepository;
import com.foodmunch.Repository.FoodMenuRepository;

@Service
@Transactional 
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	@Autowired
	FoodMenuService menuService;
	
	@Override
	public Cart CreateCart(Cart cart) {
		Cart c = cartRepository.save(cart);
		float total =0;
		for (OrderItems item : cart.getOrderItems()) {
			int itemId = item.getOrderFoodId();
			total += item.getQuantity() * menuService.getDishPrice(itemId);
		}
		cart.setTotalPrice(total);
		return cartRepository.save(cart);
		
	}

	@Override
	public Cart UpdateCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public String deleteCart(int cartNo) {
		// TODO Auto-generated method stub
		 cartRepository.deleteById(cartNo);
		return "Cart Deleted";
	}

	@Override
	public Cart readCart(int cartNo) {
		return cartRepository.findById(cartNo).get();
	}

}
