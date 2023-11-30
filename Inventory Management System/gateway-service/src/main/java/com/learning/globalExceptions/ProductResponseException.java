package com.learning.globalExceptions;

public class ProductResponseException extends RuntimeException {

	public ProductResponseException(String message) {
		super(message);
	}
}
