package com.learning.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.OrderEntity;
import com.learning.enums.Status;
import com.learning.globalException.OrderResponseException;
import com.learning.model.OrderRequest;
import com.learning.model.OrderResponse;
import com.learning.repository.OrderRepository;
import com.learning.utility.Convertor;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private Convertor convertor;

	public OrderResponse createOrder(OrderRequest orderRequest) {
		OrderResponse orderResponse = null;
		if (Objects.nonNull(orderRequest)) {
			OrderEntity orderEntity = convertor.requestToEntity(orderRequest);
			orderEntity = orderRepository.save(orderEntity);
			orderResponse = convertor.entityToResponse(orderEntity);
		}
		return orderResponse;
	}

	// Find By Order Id
	public OrderResponse findByOrderId(Long orderId) {
		Optional<OrderEntity> orderEntityOptional = orderRepository.findByOrderId(orderId);
		if (orderEntityOptional.isPresent()) {
			OrderEntity orderEntity = orderEntityOptional.get();
			return convertor.entityToResponse(orderEntity);
		} else {
			throw new OrderResponseException("Order not found for ID: " + orderId);
		}
	}

	public OrderResponse updateOrder(Long orderId, OrderRequest orderRequest) {
		return orderRepository.findById(orderId).map(orderEntity -> {
			orderEntity = convertor.updateEntity(orderRequest, orderEntity);
			orderEntity = orderRepository.save(orderEntity);
			return convertor.entityToResponse(orderEntity);
		}).orElseThrow(() -> new OrderResponseException("Order Not Found"));
	}

	public Status deleteOrder(Long orderId) {
		Optional<OrderEntity> optionalEntity = orderRepository.findById(orderId);
		if (Objects.nonNull(optionalEntity)) {
			orderRepository.deleteById(orderId);
			return Status.SUCCESS;
		}
		return Status.FAILED;
	}

}
