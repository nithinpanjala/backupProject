package com.foodmunch.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Exceptions.CustomException;
import com.foodmunch.Repository.CustomerAddressRepository;
import com.foodmunch.Repository.CustomerRepository;




@Service
@Transactional 
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository userRepository;

	@Autowired
	private CustomerAddressRepository addressRepository;
	
	@Autowired
	private CustomerAddressService customerAddressService; 

	@Override
	public Customer userSignUp(Customer user) {
		return userRepository.save(user);
	}

	
	@Override
	public Customer updateUser(Customer user) {
	return userRepository.save(user);
	}

	@Override
	public Customer updateUserPassword(long userId, String userPassword, String newUserPassword) throws CustomException {

		Customer user = userRepository.findById(userId).get();
		if (user == null) {
			throw new CustomException("no user found");
		} else {
			user.setCustomerPassword(newUserPassword);
			System.out.println("***************");
			System.out.println(user.getCustomerPassword());
			System.out.println("***************");
			return userRepository.save(user);
		}

	}
	
	@Override
	public Customer updateUsermobile(String userName, String userPassword, String newUsermobile) throws CustomException {
		
		if (userRepository.findByCustomerNameAndCustomerPassword(userName , userPassword).isPresent()) {
			Customer user = userRepository.findByCustomerNameAndCustomerPassword(userName , userPassword).get();
			user.setCustomerMobile(newUsermobile);
			return userRepository.save(user);
		} else {
			throw new CustomException("no user found");
		}
	}
	
	
	@Override
	public Customer updateUserEmail(String userName, String userPassword, String newUserEmail) throws CustomException {
		
		if (userRepository.findByCustomerNameAndCustomerPassword(userName , userPassword).isPresent()) {
			Customer user = userRepository.findByCustomerNameAndCustomerPassword(userName , userPassword).get();
			user.setCustomerEmail(newUserEmail);
			return userRepository.save(user);
		} else {
			throw new CustomException("no user found");
		}
	}
	

	@Override
	public Customer readUser(long userId, String userPassword) throws CustomException {

		if (userRepository.findById(userId).isPresent()) {

			return userRepository.findById(userId).get();

		} else {
			throw new CustomException("no user found");
		}
	}
	@Override
	public Customer readUserByUserNameAndPassword(String userName, String userPassword) throws CustomException{
		if (userRepository.findByCustomerNameAndCustomerPassword(userName , userPassword).isPresent()) {

			return userRepository.findByCustomerNameAndCustomerPassword(userName , userPassword).get();

		} else {
			throw new CustomException("no user found");
		}
	}



	@Override
	public String deleteByUserIdAndUserPassword(long userId, String userPassword) throws CustomException  {
		if(userRepository.findByCustomerIdAndCustomerPassword(userId,userPassword).isEmpty()) {
			throw new CustomException("no User Found with the Id :"+ userId);
			
		}else {
			List<CustomerAddress> addresses = customerAddressService.getAllAddress(userRepository.findByCustomerIdAndCustomerPassword(userId, userPassword).get().getCustomerId());
			for (CustomerAddress address : addresses) {
				addressRepository.deleteById(address.getCustAddressId());
			}
			userRepository.deleteById(userId);
			return "User "+ userId + " deleted";
		}
		
		
		
	}

	@Override
	public String deleteByUserNameAndUserPassword(String userName, String userPassword) throws CustomException  {
		if(userRepository.findByCustomerNameAndCustomerPassword(userName, userPassword).isEmpty()) {
			throw new CustomException("no address with that Id found");
			
		}else {
			
			List<CustomerAddress> addresses = customerAddressService.getAllAddress(userRepository.findByCustomerNameAndCustomerPassword(userName, userPassword).get().getCustomerId());
			for (CustomerAddress address : addresses) {
				addressRepository.deleteById(address.getCustAddressId());
			}
			userRepository.deleteById(userRepository.findByCustomerNameAndCustomerPassword(userName, userPassword).get().getCustomerId());
			return "User "+ userName + " deleted";

		}
	}

	




}