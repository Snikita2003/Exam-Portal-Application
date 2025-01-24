package com.exam.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;


public class Authority implements GrantedAuthority{

	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	private String authority;
	
	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String getAuthority() {
		
		
		return this.authority;
	}
	
	

}
