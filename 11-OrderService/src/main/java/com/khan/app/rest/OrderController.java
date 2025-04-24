package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.consumer.CartConsumer;
import com.khan.app.entity.Cart;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartConsumer cartConsumer;
	
	@GetMapping("/msg")
	public ResponseEntity<String> getMsg()
	{
		return ResponseEntity.ok( "Order: "+cartConsumer.getMsg().getBody());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable("id") int path)
	{
		Cart body = cartConsumer.getCart(path).getBody();
		
		return ResponseEntity.ok(body);
	}

	@PostMapping("/save")
	public ResponseEntity<Cart> getCart(@RequestBody Cart cart){
		
		
		return ResponseEntity.ok(cartConsumer.getCart(cart).getBody());
	}
}
