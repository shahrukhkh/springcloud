package com.khan.app.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Ms1Consumer {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	public String getMs1Response()
	{
		List<ServiceInstance> instances = discoveryClient.getInstances("MS1");
		ServiceInstance serviceInstance = instances.get(0);
		URI uri = serviceInstance.getUri();
		
		String url= uri+"/ms1/";
		
		RestTemplate rs=new RestTemplate();
		ResponseEntity<String> forEntity = rs.getForEntity(url, String.class);
		String body = forEntity.getBody();
		return body;
	}

	
}
