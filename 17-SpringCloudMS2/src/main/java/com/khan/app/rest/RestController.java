package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khan.app.consumer.Ms1Consumer;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/ms2")
public class RestController {

	@Autowired
	private Ms1Consumer consumer;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String getMsg()
	{
		return "Goooooooood Morning! from MS2 "+port+" and "+consumer.getMs1Response();
	}
}
