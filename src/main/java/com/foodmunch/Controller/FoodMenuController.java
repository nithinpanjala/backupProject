package com.foodmunch.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodmunch.Entity.FoodMenu;
import com.foodmunch.Entity.Restaurant;
import com.foodmunch.Entity.FoodMenu.FoodType;
import com.foodmunch.Services.FoodMenuService;
import com.foodmunch.Services.RestaurantServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/FoodMenuOperations")
public class FoodMenuController {
	@Autowired
	RestaurantServices restaurantServices;
	@Autowired
	FoodMenuService foodMenuService;

	/*
	 * *************************************************************************
	 * Dish operations
	 * ***********************************************************************
	 */

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */

	@PostMapping(value = "/addDishes")
	public ResponseEntity<FoodMenu> addDishes(@RequestBody FoodMenu dish) {
		dish.setImageurl(null);
		return new ResponseEntity<FoodMenu>(foodMenuService.addDishes(dish), HttpStatus.OK);

	}

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	@DeleteMapping(value = "/deleteDish/{dishId}")
	public ResponseEntity<String> deleteDish(@PathVariable("dishId") int dishId) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String s = restaurantServices.deleteDish(dishId);
		return new ResponseEntity<String>(mapper.writeValueAsString(s), HttpStatus.OK);
	}

	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	@PutMapping(value = "/updateDishQuantity/{quantity}/{dishId}")
	public ResponseEntity<FoodMenu> updateDishQuantity(@PathVariable("quantity") int quantity,
			@PathVariable("dishId") int dishId) {
		return new ResponseEntity<FoodMenu>(restaurantServices.updateDishQuantity(quantity, dishId), HttpStatus.OK);

	}

	@PutMapping(value = "/updateDish")
	public ResponseEntity<FoodMenu> updateDish(@RequestBody FoodMenu dish) {
		return new ResponseEntity<FoodMenu>(restaurantServices.updateDish(dish), HttpStatus.OK);

	}

	@PutMapping(value = "/updateDishQuantityAndPrice/{quantity}/{price}/{dishId}")
	public ResponseEntity<FoodMenu> updateDishQuantityAndPrice(@PathVariable("quantity") int quantity,
			@PathVariable("price") float price, @PathVariable("dishId") int dishId) {
		return new ResponseEntity<FoodMenu>(restaurantServices.updateDishQuantityAndPrice(quantity, price, dishId),
				HttpStatus.OK);

	}

	/*
	 * *************************************************************************
	 * Read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/readDish")
	public ResponseEntity<FoodMenu> readDish(@RequestParam int Dishid) {
		return new ResponseEntity<FoodMenu>(restaurantServices.readDish(Dishid), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllDishes")
	public ResponseEntity<Set<FoodMenu>> getAllDishes(@RequestParam int restaurantId) {
		Set<FoodMenu> s = restaurantServices.getAllDishes(restaurantId);
		
		for (FoodMenu file : s) {
		
			file.setImageurl(decompressBytes(file.getImageurl()));
		}
		return new ResponseEntity<Set<FoodMenu>>(s, HttpStatus.OK);
	}

	@GetMapping(value = "/getVeg")
	public ResponseEntity<Set<FoodMenu>> getVeg(@RequestParam int restaurantId) {
		return new ResponseEntity<Set<FoodMenu>>(restaurantServices.getOnlyVeg(restaurantId), HttpStatus.OK);
	}

	@GetMapping(value = "/getNonVeg")
	public ResponseEntity<Set<FoodMenu>> getNonVeg(@RequestParam int restaurantId) {
		return new ResponseEntity<Set<FoodMenu>>(restaurantServices.getOnlyNonVeg(restaurantId), HttpStatus.OK);
	}

	/*
	 * *************************************************************************
	 * image operations
	 * ***********************************************************************
	 */

	@PutMapping("/upload")
	public ResponseEntity<FoodMenu>  uplaodImage(
			 @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		System.out.println("**********************************************************************");
		System.out.println("image getOriginalFilename :" + imageFile.getOriginalFilename());
		System.out.println("image get name :" + imageFile.getName());
		System.out.println("image type :" + imageFile.getContentType());
		System.out.println("image getSize :" + imageFile.getSize());
		System.out.println("**********************************************************************");

		return new ResponseEntity<FoodMenu>(foodMenuService.uploadImage(Integer.parseInt(imageFile.getOriginalFilename()),compressBytes(imageFile.getBytes())), HttpStatus.OK);


	}

	@GetMapping(path = { "/get/{foodId}" })
	public FoodMenu getDishWithImage(@PathVariable("foodId") int foodId) throws IOException {

		FoodMenu file = foodMenuService.readDish(foodId);
		//MultipartFile imageFile = decompressBytes(file.getImageurl());
		FoodMenu img = new FoodMenu(file.getFoodId(), file.getFoodName(), file.getFoodPrice(),
				file.getFoodQuantityAvailable(), decompressBytes(file.getImageurl()), file.getIsVegeterian(),
				file.getRestaurant());
		return img;
	}

	// compress the image bytes before storing it in the database

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
