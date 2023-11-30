package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.enums.Status;
import com.learning.model.OrderRequest;
import com.learning.model.OrderResponse;

@FeignClient(value = "OrderServiceClient", url = "http://localhost:8094/order")
public interface OrderServiceClient {

	@PostMapping
	public OrderResponse postOrder(@RequestBody OrderRequest orderRequest);

	@GetMapping("/{orderId}")
	public OrderResponse getByOrderId(@PathVariable Long orderId);

	@PutMapping("/{orderId}")
	public OrderResponse updateOrder(@PathVariable Long orderId, @RequestBody OrderRequest orderRequest);

	@DeleteMapping("/{orderId}")
	public Status deleteOrder(@PathVariable Long orderId);
}
