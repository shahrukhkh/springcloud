package com.khan.app;

import org.springframework.stereotype.Component;

@Component
public class Connection {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	
	@Override
	public String toString() {
		return "Connection [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password + "]";
	}
	
	
	

}
