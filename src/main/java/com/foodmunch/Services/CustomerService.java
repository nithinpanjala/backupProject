package com.foodmunch.Services;


import java.util.List;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Exceptions.CustomException;



public interface CustomerService {
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	public Customer userSignUp(Customer customer) throws CustomException;
/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public Customer readUserById(long userId) throws CustomException;
	public Customer readUser(long userId, String userPassword) throws CustomException;
	public Customer readUserByUserNameAndPassword(String userName, String userPassword) throws CustomException;
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public Customer updateUser(Customer user) throws CustomException; // update
	public Customer updateUserPassword(String userName, String userPassword, String newUserPassword) throws CustomException;// update
	public Customer updateUsermobile(String userName, String userPassword, String newUsermobile) throws CustomException;
	public Customer updateUserEmail(String userName, String userPassword, String newUserEmail) throws CustomException;

	

	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	public String deleteByUserIdAndUserPassword(long userId, String userPassword) throws CustomException;
	public String deleteByUserNameAndUserPassword(String userName, String userPassword) throws CustomException;
	public List<Customer> getAllCustomers();

	


	
}
