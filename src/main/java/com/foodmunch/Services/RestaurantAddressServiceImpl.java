package com.foodmunch.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Entity.RestaurantAddress;
import com.foodmunch.Exceptions.CustomException;
import com.foodmunch.Repository.RestaurantAddressrRepository;
import com.foodmunch.Repository.RestaurantRepository;


@Service
@Transactional 
public class RestaurantAddressServiceImpl implements RestaurantAddressService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RestaurantAddressrRepository restaAddressrRepository;

	@Autowired
	private RestaurantServices restaurantServices;

	@Override
	public Restaurant addAddress(RestaurantAddress address) throws CustomException {
		restaAddressrRepository.save(address);
		return address.getRestaurant();
	}


	@Override
	public RestaurantAddress getSelectedAddress(int addressId) throws CustomException {
		if(restaAddressrRepository.existsById(addressId)) {
			return restaAddressrRepository.findById(addressId).get();
	
		}else {
			throw new CustomException("Invalid restaurant address Id");
		}

	}

	@Override
	public RestaurantAddress updateAddress(RestaurantAddress address) throws CustomException {
		return	restaAddressrRepository.save(address);
	}

	@Override
	public RestaurantAddress updateLandmark(int addressId, String landmark) throws CustomException {
		if(restaAddressrRepository.existsById(addressId)) {
			RestaurantAddress address= restaAddressrRepository.findById(addressId).get();
			address.setRestaurantLandmark(landmark);
			return restaAddressrRepository.save(address);
		}else {
			throw new CustomException("no address with that Id found");
		}
	}

	@Override
	public RestaurantAddress updateHouseNoAndStreet(int addressId, String houseNumber, String addressLane1)
			throws CustomException {
		if(restaAddressrRepository.existsById(addressId)) {
			RestaurantAddress address= restaAddressrRepository.findById(addressId).get();
			address.setRestaurantBuildingNumber(houseNumber);
			address.setRestaurantAddressLane1(addressLane1);
			return restaAddressrRepository.save(address);
		}else {
			throw new CustomException("no address with that Id found");
		}
	}

	@Override
	public String deleteAddressByRestaurantId(long restaurantId, String restaurantPassword) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAddressById(int addressId) throws CustomException {
		if(restaAddressrRepository.existsById(addressId)) {
			restaAddressrRepository.deleteById(addressId);
			 return "The selected address is deleted";
		}else {
			throw new CustomException("no address with that Id found");
		}
	}


	@Override
	public Restaurant addRestaurantAddress(String houseNumber, String addressLane1, String addressLane2,
			String landmark, int pincode, String district, String state, int restaurantId) throws CustomException {
		if (restaurantRepository.findById(restaurantId).isPresent()) {
			RestaurantAddress address = new RestaurantAddress();
			address.setRestaurantBuildingNumber(houseNumber);
			address.setRestaurantAddressLane1(addressLane1);
			address.setRestaurantAddressLane2(addressLane2);
			address.setRestaurantLandmark(landmark);
			address.setRestaurantPincode(pincode);
			address.setRestaurant(restaurantRepository.findById(restaurantId).get());
			address.setRestaurantDistrict(district);
			address.setRestaurantState(state);
			restaAddressrRepository.save(address);
			restaurantRepository.findById(restaurantId).get().setRestaurantAddress(address);
			return restaurantRepository.findById(restaurantId).get();

		} else {
			throw new CustomException("no restaurant found");
		}
		
	}

	

}
