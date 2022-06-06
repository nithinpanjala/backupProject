package com.foodmunch.Services;

import java.util.List;

import com.foodmunch.Entity.RestaurantAdmin;
import com.foodmunch.Exceptions.CustomException;

public interface RestaurantAdminService {

	public RestaurantAdmin userSignUp(RestaurantAdmin customer) throws CustomException;
	/*
		 * *************************************************************************
		 * read operations
		 * ***********************************************************************
		 */
		public RestaurantAdmin readUser(long userId, String userPassword) throws CustomException;
		public RestaurantAdmin readUserByUserNameAndPassword(String userName, String userPassword) throws CustomException;
		/*
		 * *************************************************************************
		 * update operations
		 * ***********************************************************************
		 */

		public RestaurantAdmin updateUser(RestaurantAdmin user) throws CustomException; // update
		public RestaurantAdmin updateUserPassword(String userName, String userPassword, String newUserPassword) throws CustomException;// update
		public RestaurantAdmin updateUsermobile(String userName, String userPassword, String newUsermobile) throws CustomException;
		public RestaurantAdmin updateUserEmail(String userName, String userPassword, String newUserEmail) throws CustomException;

		

		
		/*
		 * *************************************************************************
		 * delete operations
		 * ***********************************************************************
		 */
		public String deleteByUserIdAndUserPassword(long userId, String userPassword) throws CustomException;
		public String deleteByUserNameAndUserPassword(String userName, String userPassword) throws CustomException;
		public List<RestaurantAdmin> getAllCustomers();

		

}
