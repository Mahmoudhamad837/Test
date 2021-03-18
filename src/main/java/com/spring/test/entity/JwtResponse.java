package com.spring.test.entity;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	
	private UserData user;

	public JwtResponse(String jwttoken, UserData user) {
		this.jwttoken = jwttoken;
		this.user = user;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public UserData getUser() {
		return user;
	}
	
}
