package com.spring.test.message;

import com.spring.test.entity.UserData;

public class ResponseMessage {
	private String message;
	private UserData user;

	
	public ResponseMessage() {
	}

	public ResponseMessage(String message, UserData user) {
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}
	 
}
