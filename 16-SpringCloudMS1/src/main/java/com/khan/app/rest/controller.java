package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms1")
public class controller {

	@Value("${spring.application.name}")
	private String name;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String getMsg()
	{
		return "hello from "+name+" : "+port;
	}
}
