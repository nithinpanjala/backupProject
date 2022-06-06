package com.foodmunch.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmunch.Entity.RestaurantAdmin;
import com.foodmunch.Exceptions.CustomException;
import com.foodmunch.Repository.RestaurantAdminRepository;



@Service
@Transactional 
public class RestaurantAdminServiceImpl implements RestaurantAdminService {
	
	@Autowired
	private RestaurantAdminRepository  restaurantAdminRepository;


	@Override
	public RestaurantAdmin userSignUp(RestaurantAdmin user) {
		return restaurantAdminRepository.save(user);
	}

	
	@Override
	public RestaurantAdmin updateUser(RestaurantAdmin user) {
	return restaurantAdminRepository.save(user);
	}

	@Override
	public List<RestaurantAdmin> getAllCustomers(){
		return restaurantAdminRepository.findAll();

	}
	
	@Override
	public RestaurantAdmin updateUserPassword(String userName, String userPassword, String newUserPassword) throws CustomException {

		RestaurantAdmin user = restaurantAdminRepository.findByAdminNameAndAdminPassword(userName , userPassword).get();
		if (user == null) {
			throw new CustomException("no user found");
		} else {
			user.setAdminPassword(newUserPassword);
			return restaurantAdminRepository.save(user);
		}

	}
	
	@Override
	public RestaurantAdmin updateUsermobile(String userName, String userPassword, String newUsermobile) throws CustomException {
		
		if (restaurantAdminRepository.findByAdminNameAndAdminPassword(userName , userPassword).isPresent()) {
			RestaurantAdmin user = restaurantAdminRepository.findByAdminNameAndAdminPassword(userName , userPassword).get();
			user.setAdminMobile(newUsermobile);
			return restaurantAdminRepository.save(user);
		} else {
			throw new CustomException("no user found");
		}
	}
	
	
	@Override
	public RestaurantAdmin updateUserEmail(String userName, String userPassword, String newUserEmail) throws CustomException {
		
		if (restaurantAdminRepository.findByAdminNameAndAdminPassword(userName , userPassword).isPresent()) {
			RestaurantAdmin user = restaurantAdminRepository.findByAdminNameAndAdminPassword(userName , userPassword).get();
			user.setAdminEmail(newUserEmail);
			return restaurantAdminRepository.save(user);
		} else {
			throw new CustomException("no user found");
		}
	}
	

	@Override
	public RestaurantAdmin readUser(long userId, String userPassword) throws CustomException {

		if (restaurantAdminRepository.findById(userId).isPresent()) {

			return restaurantAdminRepository.findById(userId).get();

		} else {
			throw new CustomException("no user found");
		}
	}
	@Override
	public RestaurantAdmin readUserByUserNameAndPassword(String userName, String userPassword) throws CustomException{
		if (restaurantAdminRepository.findByAdminNameAndAdminPassword(userName , userPassword).isPresent()) {

			return restaurantAdminRepository.findByAdminNameAndAdminPassword(userName , userPassword).get();

		} else {
			throw new CustomException("no user found");
		}
	}



	@Override
	public String deleteByUserIdAndUserPassword(long userId, String userPassword) throws CustomException  {
		if(restaurantAdminRepository.findByAdminIdAndAdminPassword(userId,userPassword).isEmpty()) {
			throw new CustomException("no User Found with the Id :"+ userId);
			
		}else {
			
			restaurantAdminRepository.deleteById(userId);
			return "User "+ userId + " deleted";
		}
		
		
		
	}

	@Override
	public String deleteByUserNameAndUserPassword(String userName, String userPassword) throws CustomException  {
		if(restaurantAdminRepository.findByAdminNameAndAdminPassword(userName, userPassword).isEmpty()) {
			throw new CustomException("no address with that Id found");
			
		}else {

			restaurantAdminRepository.deleteById(restaurantAdminRepository.findByAdminNameAndAdminPassword(userName, userPassword).get().getAdminId());
			return "User "+ userName + " deleted";

		}
	}

	
}
