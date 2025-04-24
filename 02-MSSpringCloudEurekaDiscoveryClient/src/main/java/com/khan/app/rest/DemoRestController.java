package com.khan.app.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

	
	@GetMapping("/msg")
	public ResponseEntity<String> getMsg()
	{
		return ResponseEntity.ok("Welcome to Spring Cloud");
	}
}
