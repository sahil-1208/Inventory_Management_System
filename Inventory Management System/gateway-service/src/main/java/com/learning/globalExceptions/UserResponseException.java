package com.learning.globalExceptions;

public class UserResponseException extends RuntimeException {
 
	public UserResponseException(String message) {
		super(message);
	}

}
