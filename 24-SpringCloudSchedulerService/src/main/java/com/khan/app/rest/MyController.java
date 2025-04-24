package com.khan.app.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyController {

	
	

	@Scheduled(cron = "10 * * * * *")
	public void makeReq()
	{
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity= new HttpEntity<>("{}",headers);
		RestTemplate rs = new RestTemplate();
		ResponseEntity<String> postForEntity = rs.postForEntity("http://localhost:8081/actuator/refresh", entity, String.class);
		
		System.out.println(postForEntity.getBody());
	}
}
