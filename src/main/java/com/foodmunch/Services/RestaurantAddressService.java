package com.foodmunch.Services;

import java.util.List;

import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Entity.RestaurantAddress;
import com.foodmunch.Exceptions.CustomException;

public interface RestaurantAddressService {


	public Restaurant addAddress(RestaurantAddress address) throws CustomException;
	public Restaurant  addRestaurantAddress( String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, long userId) throws CustomException;

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	
	public RestaurantAddress  getSelectedAddress(int addressId) throws CustomException;

	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	
	public RestaurantAddress updateAddress(RestaurantAddress address) throws CustomException; // update
	public RestaurantAddress updateLandmark(int addressId,String landmark) throws CustomException; // update
	public RestaurantAddress updateHouseNoAndStreet(int addressId,String houseNumber , String addressLane1) throws CustomException; // update


	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	
	public String deleteAddressByRestaurantId(long restaurantId, String userPassword) throws CustomException; // delete
	public String deleteAddressById(int addressId) throws CustomException; // delete
	
	
	
}
