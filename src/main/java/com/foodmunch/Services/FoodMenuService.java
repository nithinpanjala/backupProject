package com.foodmunch.Services;

import java.util.List;

import com.stg.entity.CreditCard;

public interface FoodMenuService {
    public CreditCard findByCardHolder(long customerId);
	public void save(CreditCard foodMenu);
	public CreditCard update(CreditCard foodMenu);
	public List<CreditCard> findAll();
	public CreditCard findOne(Long id);
	public List<CreditCard >findAllMenuByResturantID(Long resturantId);
}
