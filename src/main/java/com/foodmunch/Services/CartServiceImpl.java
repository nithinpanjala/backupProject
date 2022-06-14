package com.foodmunch.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodmunch.Entity.Cart;
import com.foodmunch.Repository.CartRepository;

@Service
@Transactional 
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart CreateCart(Cart cart) {
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
