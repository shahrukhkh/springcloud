package com.khan.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Connection{
	@Value("${my.db.driver}")
	private String driver;
	
	@Value("${my.db.url}")
	private String url;
	
	@Value("${my.db.user}")
	private String user;
	
	@Value("${my.db.password}")
	private String password;

	@Override
	public String toString() {
		return "Connection [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password + "]";
	}

	
	
	

}
