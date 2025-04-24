package com.khan.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class Runnring implements CommandLineRunner{
	@Autowired
	private Connection con;
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(con);
		
	}

}
