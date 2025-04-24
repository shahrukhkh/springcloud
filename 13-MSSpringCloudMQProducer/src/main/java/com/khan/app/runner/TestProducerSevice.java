package com.khan.app.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.khan.app.service.ProducerSevice;
@Component
public class TestProducerSevice {
//implements CommandLineRunner {

	@Autowired
	private ProducerSevice producerSevice;
	//@Override
	//public void run(String... args) throws Exception {
	@Scheduled(cron = "*/5 * * * * *")
	public void send() throws Exception{
		producerSevice.sendMsg("Hello: "+ new Date());
	}

}
