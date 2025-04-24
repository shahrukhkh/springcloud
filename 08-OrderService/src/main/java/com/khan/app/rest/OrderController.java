package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.consumer.CartConsumer;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartConsumer cartConsumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> getOrder()
	{
		return ResponseEntity.ok("Order: "+cartConsumer.getCartResponse());
	}
}
