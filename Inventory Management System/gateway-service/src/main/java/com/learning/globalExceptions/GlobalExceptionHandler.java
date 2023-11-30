package com.learning.globalExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderResponseException.class)
	public ResponseEntity<String> handleOrderResponseException(OrderResponseException orderResponseException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(orderResponseException.getMessage());

	}
	
	@ExceptionHandler(ProductResponseException.class)
	public ResponseEntity<String> handleOrderResponseException(ProductResponseException productResponseException){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productResponseException.getMessage());
		
	}
	
	@ExceptionHandler(UserResponseException.class)
    public ResponseEntity<String> handleUserResponseException(UserResponseException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	@ExceptionHandler(CustomerResponseException.class)
	public ResponseEntity<String>  handleCustomerResponseException(CustomerResponseException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
	@ExceptionHandler(SupplierResponseException.class)
	public ResponseEntity<String> handleOrderResponseException(SupplierResponseException supplierResponseException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(supplierResponseException.getMessage());

	}
}
