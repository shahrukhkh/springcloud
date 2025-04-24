package com.khan.app.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumer {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	
	public String getCartResponse()
	{
		ServiceInstance choose = loadBalancerClient.choose("07-CartService");
		URI uri = choose.getUri();
		String url=uri+"/cart/info";
		RestTemplate rs= new RestTemplate();
		ResponseEntity<String> forEntity = rs.getForEntity(url, String.class);
		
		return forEntity.getBody();
	}
}
