package com.exam.exception;

public class ResNotFoundException extends RuntimeException {

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	String username;

	public ResNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResNotFoundException(String username) {
		super( String.format("this username not found - %s", username ) );
		this.username = username;
	}
	
}
