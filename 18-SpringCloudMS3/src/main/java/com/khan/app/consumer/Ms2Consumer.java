package com.khan.app.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Ms2Consumer {

	@Autowired
	private LoadBalancerClient balancerClient;
	
	public String getMS3Response()
	{
		ServiceInstance choose = balancerClient.choose("MS2");
		
		URI uri = choose.getUri();
		
		String url= uri+"/ms2/";
		
		RestTemplate rs = new RestTemplate();
		ResponseEntity<String> forEntity = rs.getForEntity(url, String.class);
		return forEntity.getBody();
	}
}
