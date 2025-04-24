package com.khan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerSevice {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${my.app.desti-name}")
	private String queue;
	
	public void sendMsg(String msg)
	{
		jmsTemplate.send(queue,session -> session.createTextMessage(msg));
		System.out.println("Msg Send "+msg);
	}
}
