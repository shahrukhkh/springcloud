package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.consumer.MS4Prodoucer;

@RestController
@RequestMapping("/ms4")
public class RestConTroller {

	@Autowired
	private MS4Prodoucer ms4Prodoucer;
	
	@GetMapping("/")
	public String getMsg()
	{
		return "Msg from ms4 and : "+ms4Prodoucer.getMsg();
	}
}
