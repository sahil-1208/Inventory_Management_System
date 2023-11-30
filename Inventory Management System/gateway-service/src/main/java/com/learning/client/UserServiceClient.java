package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.enums.Status;
import com.learning.model.UserRequest;
import com.learning.model.UserResponse;


@FeignClient(value = "UserServiceClient" , url = "http://localhost:8090/user"  )
public interface UserServiceClient {

	@PostMapping
	public UserResponse createNewUser(@RequestBody UserRequest userRequest);

	@GetMapping("/{userId}")
	public UserResponse getByUserId(@PathVariable Long userId);
	
	@PutMapping("/{userId}")
	public UserResponse updateUserById(@PathVariable Long userId, @RequestBody UserRequest userRequest);
	
	@DeleteMapping("/{userId}")
	public Status deleteUserById(@PathVariable Long userId);
	
}
