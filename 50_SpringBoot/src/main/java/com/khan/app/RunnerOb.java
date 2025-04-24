package com.khan.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerOb implements CommandLineRunner{
	
    @Autowired
	private DataBaseCon con;
    
	
	
	



	@Override
	public void run(String...args) throws Exception{
		System.out.println(con);
		
	}
	

}
