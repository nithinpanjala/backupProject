package com.foodmunch.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional 
public class FoodMenuServiceImpl implements FoodMenuService{
	
	@Autowired
    private FoodMenuService   foodMenuDao;

    public void save( CreditCard foodMenu) {  		
    	foodMenuDao.save(foodMenu);
	}
    public CreditCard findByCardHolder(long customerId) {
        return foodMenuDao.findByCardHolder(customerId);
    }
    
    public CreditCard update( CreditCard  foodMenu) {  		
		return foodMenuDao.update(foodMenu);
	}
	
  	
	public List<CreditCard> findAll() {
		return (List<CreditCard>)foodMenuDao.findAll();
	}

	
	public CreditCard findOne(Long id) {
		return foodMenuDao.findOne(id);
	}
	public List<CreditCard>findAllMenuByResturantID(Long resturantId) {
		return foodMenuDao.findAllMenuByResturantID(resturantId);
	}
	
	

}