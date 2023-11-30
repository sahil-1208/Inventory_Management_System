package com.learning.globalExceptions;

public class CustomerResponseException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerResponseException(String message) {
		super(message);
	}

}
