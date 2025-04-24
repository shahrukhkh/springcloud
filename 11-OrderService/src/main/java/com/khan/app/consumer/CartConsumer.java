package com.khan.app.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.khan.app.entity.Cart;

@Component
@FeignClient("10-CARTSERVICE")
public interface CartConsumer {

	@GetMapping("/cart/msg")
	public ResponseEntity<String> getMsg();
	
	@GetMapping("/cart/get/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable("id") int path);

	@PostMapping("/cart/save")
	public ResponseEntity<Cart> getCart(@RequestBody Cart cart);
	
}
