package com.khan.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class controller {

	@Value("${app.msg}")
	private String msg;
	
	@GetMapping("/")
	public String getMsg()
	{
		return msg;
	}
}
