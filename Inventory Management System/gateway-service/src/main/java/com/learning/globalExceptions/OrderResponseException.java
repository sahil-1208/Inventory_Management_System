package com.learning.globalExceptions;

public class OrderResponseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderResponseException(String message) {
		super(message);
	}
}
