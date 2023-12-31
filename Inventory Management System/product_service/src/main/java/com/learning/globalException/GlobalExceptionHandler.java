package com.learning.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler {
	
@ExceptionHandler(ProductResponseException.class)
public ResponseEntity<String> handleOrderResponseException(ProductResponseException productResponseException){
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productResponseException.getMessage());
	
}
}