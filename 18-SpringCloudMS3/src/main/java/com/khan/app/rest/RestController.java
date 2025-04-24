package com.khan.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khan.app.consumer.Ms2Consumer;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/ms3")
public class RestController {

	@Autowired
	private Ms2Consumer ms2Consumer;
	
	@Value("${server.port}")
	private String port;
	@GetMapping("/")
	public String getMsg()
	{
		return "Welecome to MS3 : "+port+" "+ms2Consumer.getMS3Response();
	}
}
