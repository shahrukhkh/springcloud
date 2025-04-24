package com.khan.app.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("MS3")
public interface MS4Prodoucer {
	
	
	@GetMapping("/ms3/")
	public String getMsg();

}
