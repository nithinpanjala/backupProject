package com.foodmunch.Services;

import java.util.List;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Exceptions.CustomException;


public interface CustomerAddressService {

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	
	public CustomerAddress addAddress(CustomerAddress address) throws CustomException;
	public Customer  addCustomerAddress( String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, long userId) throws CustomException;

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	
	public CustomerAddress  getSelectedAddress(int addressId) throws CustomException;
	public List<CustomerAddress> getAllAddress(long userId) throws CustomException;

	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	
	public CustomerAddress updateAddress(CustomerAddress address) throws CustomException; // update
	public CustomerAddress updateLandmark(int addressId,String landmark) throws CustomException; // update
	public CustomerAddress updateHouseNoAndStreet(int addressId,String houseNumber , String addressLane1) throws CustomException; // update


	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	
	public String deleteAddressByUserId(long userId, String userPassword) throws CustomException; // delete
	public String deleteAddressByID(int addressId) throws CustomException; // delete
	
	

}
