package com.foodmunch.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.foodmunch.Entity.Cart;
import com.foodmunch.Services.CartService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/cartOperations")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping(value = "/CreateCart")
	public ResponseEntity<Cart>  CreateCart( @Valid @RequestBody  Cart cart) {
		return new ResponseEntity<Cart>(cartService.CreateCart(cart), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/UpdateCart")
	public  ResponseEntity<Cart>   UpdateCart(@Valid @RequestBody  Cart cart){
		return new ResponseEntity<Cart>(cartService.UpdateCart(cart), HttpStatus.ACCEPTED);
	
	}

	@DeleteMapping(value = "/deleteCart/{cartNo}")
	public  ResponseEntity<String>   deleteCart( @PathVariable("cartNo")  int cartNo){
		return new ResponseEntity<String>(cartService.deleteCart(cartNo), HttpStatus.ACCEPTED);

	}
	
	@GetMapping(value = "/readCart")
	public  ResponseEntity<Cart>   readCart(@RequestParam  int cartNo){
		return new ResponseEntity<Cart>(cartService.readCart(cartNo), HttpStatus.ACCEPTED);
	
	}
}
