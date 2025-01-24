package com.exam.entity;

import org.springframework.stereotype.Component;

// responce. jwt ager username, password valid hoga to send karenge client ko ( tocken bhejna hoga) .


@Component
public class JwtResponce {

	
	private String token;

	public JwtResponce() {
		super();
		// TODO Auto-generated consructor stub
	}

	public JwtResponce(String token) {
		super();
		this.token = token;
	}
	
	
	public String getToken() {
		System.out.println("Token-- "+ token );
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	
}
