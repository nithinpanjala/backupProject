package com.foodmunch.Services;

import com.foodmunch.Entity.Cart;

public interface CartService {
	public Cart CreateCart(Cart cart);

	public Cart UpdateCart(Cart cart);

	public String deleteCart(int cartNo);

	public Cart readCart(int cartNo);
}
