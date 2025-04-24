package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public ResponseEntity<String> getCart()
	{
		return ResponseEntity.ok("CART SERVICE: "+port);
	}
}
