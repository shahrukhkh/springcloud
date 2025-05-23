package com.khan.app.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController {

	@GetMapping("/info")
	public ResponseEntity<String> getCartRes()
	{
		return ResponseEntity.ok("Response from cart...");
	}
}
