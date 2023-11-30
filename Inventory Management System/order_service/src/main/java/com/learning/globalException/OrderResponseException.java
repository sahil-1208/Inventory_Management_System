package com.learning.globalException;

public class OrderResponseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderResponseException(String message) {
		super(message);
	}
}
