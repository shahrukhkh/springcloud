package com.khan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${my.app.topic.name}")
	private String topicName;
	public void sendMsg(String msg)
	{
		log.info("msg at producer service : "+msg);
		kafkaTemplate.send(topicName,msg);
	}
}
