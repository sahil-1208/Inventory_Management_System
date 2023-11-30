package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.enums.Status;
import com.learning.model.CustomerRequest;
import com.learning.model.CustomerResponse;

@FeignClient(value = "CustomerServiceClient", url = "http://localhost:8091/customer")
public interface CustomerServiceClient {

	@PostMapping
	public CustomerResponse createNewCustomer(@RequestBody CustomerRequest customerRequest);

	@GetMapping("/{customerId}")
	public CustomerResponse getByCustomerId(@PathVariable Long customerId);

	@PutMapping("/{customerId}")
	public CustomerResponse updateCustomerById(@PathVariable Long customerId, @RequestBody CustomerRequest customerRequest);

	@DeleteMapping("/{customerId}")
	public Status deleteById(@PathVariable Long customerId);

}
