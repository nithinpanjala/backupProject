package com.foodmunch.Controller;

import java.util.List;

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
import com.foodmunch.Entity.OrderItems;
import com.foodmunch.Services.OrderTableService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/OrderItemsOperations")
public class OrderItemsController {
	
	@Autowired
	OrderTableService orderTableService;

	@PostMapping(value = "/CreateOrderItems")
	public ResponseEntity<OrderItems>  CreateOrderItems( @Valid @RequestBody  OrderItems orderItems) {
	System.out.println("************************");
	System.out.println(orderItems.getOrderCustId());
	System.out.println("************************");

		return new ResponseEntity<OrderItems>(orderTableService.CreateOrderItems(orderItems), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/UpdateOrderItems")
	public  ResponseEntity<OrderItems>   UpdateOrderItems(@Valid @RequestBody  OrderItems orderItems){
		return new ResponseEntity<OrderItems>(orderTableService.UpdateOrderItems(orderItems), HttpStatus.ACCEPTED);
	
	}

	@DeleteMapping(value = "/deleteOrderItems/{cartNo}")
	public  ResponseEntity<String>   deleteOrderItems( @PathVariable("cartNo")  int orderItemsId){
		return new ResponseEntity<String>(orderTableService.deleteOrderItems(orderItemsId), HttpStatus.ACCEPTED);

	}
	
	@GetMapping(value = "/readOrderItems")
	public  ResponseEntity<OrderItems>   readOrderItems(@RequestParam  int orderItemsId){
		return new ResponseEntity<OrderItems>(orderTableService.readOrderItems(orderItemsId), HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping(value = "/readAll")
	public  ResponseEntity<List<OrderItems>>   readAll(@RequestParam  int cartNo){
		List<OrderItems> items = orderTableService.readAllOrderItemsByCartNo(cartNo);
		for (OrderItems orderItems : items) {
			System.out.println(orderItems.getQuantity()+"quantity");
		}
		return new ResponseEntity<List<OrderItems>>(orderTableService.readAllOrderItemsByCartNo(cartNo), HttpStatus.ACCEPTED);
	
	}
}
