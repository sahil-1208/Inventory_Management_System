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
import com.learning.model.OrderRequest;
import com.learning.model.OrderResponse;
import com.learning.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping
	public OrderResponse postOrder(@RequestBody OrderRequest orderRequest) {
		return orderService.createOrder(orderRequest);
	}
	
//	@GetMapping("/id/{id}")
//	public OrderResponse getOrderById(@PathVariable Long id) {
//		return orderService.findOrderById(id);
//	}
//	
	@GetMapping("/{orderId}")
	public OrderResponse getByOrderId(@PathVariable Long orderId) {
		return orderService.findByOrderId(orderId);
	}
	
	@PutMapping("/{orderId}")
	public OrderResponse updateOrder(@PathVariable Long orderId ,@RequestBody OrderRequest orderRequest) {
		return orderService.updateOrder(orderId, orderRequest);
	}
	
	@DeleteMapping("/{orderId}")
	public Status deleteOrder(@PathVariable Long orderId) {
		return orderService.deleteOrder(orderId);
	}
	
}
