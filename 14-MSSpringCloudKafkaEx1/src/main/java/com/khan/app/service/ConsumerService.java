package com.khan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.khan.app.db.MessageStore;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@Autowired
	private MessageStore messageStore;
	
	@KafkaListener(topics = "${my.app.topic.name}",groupId = "abcd")
	public void readMsg(String msg)
	{
		log.info("msg at consumer service : "+msg);
		messageStore.add(msg);
	}
}
