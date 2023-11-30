package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.enums.Status;
import com.learning.model.CustomerRequest;
import com.learning.model.CustomerResponse;
import com.learning.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public CustomerResponse createNewCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.create(customerRequest);
	}

	@GetMapping("/{customerId}")
	public CustomerResponse getByCustomerId(@PathVariable Long customerId) {
		return customerService.findByCustomerId(customerId);
	}

	@PutMapping("/{customerId}")
	public CustomerResponse updateCustomerById(@PathVariable Long customerId, @RequestBody CustomerRequest customerRequest) {
		return customerService.updateCustomerById(customerId, customerRequest);
	}

	@DeleteMapping("/{customerId}")
	public Status deleteById(@PathVariable Long customerId) {
		return customerService.deleteById(customerId);

	}

}
