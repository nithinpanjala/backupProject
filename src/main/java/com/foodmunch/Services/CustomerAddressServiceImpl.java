package com.foodmunch.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Exceptions.CustomException;
import com.foodmunch.Repository.CustomerAddressRepository;
import com.foodmunch.Repository.CustomerRepository;


@Service
@Transactional 
public class CustomerAddressServiceImpl implements CustomerAddressService{


	
	@Autowired
	private CustomerRepository userRepository;

	@Autowired
	private CustomerAddressRepository addressRepository;


	public Customer  addCustomerAddress( String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, long userId) throws CustomException{

		if (userRepository.findById(userId).isPresent()) {
			CustomerAddress address = new CustomerAddress();
			address.setCustHouseNumber(houseNumber);
			address.setCustAddressLane1(addressLane1);
			address.setCustAddressLane2(addressLane2);
			address.setCustLandmark(landmark);
			address.setCustPincode(pincode);
			address.setCustDistrict(district);
			address.setCustState(state);
			addressRepository.save(address);
			return userRepository.findById(userId).get();

		} else {
			throw new CustomException("no user found");
		}
		
		
	}
	
	
	
	@Override
	public Customer addAddress(CustomerAddress address)  throws CustomException {
		addressRepository.save(address);
		return address.getCustomer();
	}
	
	
	
	@Override
	public CustomerAddress updateAddress(CustomerAddress address) throws CustomException
	{
		return	addressRepository.save(address);
	}
	@Override
	public CustomerAddress updateLandmark(int addressId,String landmark) throws CustomException{ // update
		if(addressRepository.existsById(addressId)) {
			CustomerAddress address= addressRepository.findById(addressId).get();
			address.setCustLandmark(landmark);
			return addressRepository.save(address);
		}else {
			throw new CustomException("no address with that Id found");
		}
	}
	@Override
	public CustomerAddress updateHouseNoAndStreet(int addressId,String houseNumber , String addressLane1) throws CustomException{
		
		if(addressRepository.existsById(addressId)) {
			CustomerAddress address=  addressRepository.findById(addressId).get();
			address.setCustHouseNumber(houseNumber);
			address.setCustAddressLane1(addressLane1);
			return addressRepository.save(address);
		}else {
			throw new CustomException("no address with that Id found");
		}
	}


	@Override
	public List<CustomerAddress> getAllAddress(long userId)  throws CustomException {
		Customer user = userRepository.findById(userId).get();
		if(user== null) {
			throw new CustomException("Invalid User ID and password");
		}else {
		return addressRepository.findAllByCustomer(user);
		}

	}
	
	@Override
	public CustomerAddress  getSelectedAddress(int addressId)  throws CustomException {
		if(addressRepository.existsById(addressId)) {
			return addressRepository.findById(addressId).get();
	
		}else {
			throw new CustomException("Invalid User address Id");
		}

	}
	
	@Override
	public String deleteAddressByUserId(long userId , String userPassword) throws CustomException{
		// delete
		if(userRepository.findByCustomerIdAndCustomerPassword(userId,userPassword).isEmpty()) {
			throw new CustomException("no User Found with the Id :"+ userId);
			
		}else {
			List<CustomerAddress> addresses = getAllAddress(userId);
			for (CustomerAddress address : addresses) {
				addressRepository.deleteById(address.getCustAddressId());
			}
			return "All the addresses of the User "+ userId + " are deleted";
		}
	}
	
	@Override
	public String deleteAddressByID(int addressId) throws CustomException{
		if(addressRepository.existsById(addressId)) {
			 addressRepository.deleteById(addressId);
			 return "The selected address is deleted";
		}else {
			throw new CustomException("no address with that Id found");
		}
	}


}
