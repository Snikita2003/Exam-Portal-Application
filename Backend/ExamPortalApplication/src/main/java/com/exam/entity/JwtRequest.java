package com.exam.entity;

import org.springframework.stereotype.Component;

// username &password request from angular/ login page/ client.


@Component
public class JwtRequest {

	
	private String username;
	private String password;
	
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
