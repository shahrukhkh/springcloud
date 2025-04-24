package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.entity.Cart;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Value("${server.port}")
	private String port;
	
	@Value("${my.app.title}")
	private String title;
	
	@GetMapping("/msg")
	public ResponseEntity<String> getMsg()
	{
	   return ResponseEntity.ok("Cart Msg:"+port+" :  "+title);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable("id") int path)
	{
		
		Cart cart = new Cart(path, "shahrukh", 5);
		return ResponseEntity.ok(cart);
	}
	@PostMapping("/save")
	public ResponseEntity<Cart> getCart(@RequestBody Cart cart)
	{
		return ResponseEntity.ok(cart);
	}
}
