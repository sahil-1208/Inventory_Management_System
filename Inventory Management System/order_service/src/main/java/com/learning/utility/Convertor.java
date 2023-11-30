package com.learning.utility;

import org.springframework.stereotype.Component;

import com.learning.entity.OrderEntity;
import com.learning.model.OrderRequest;
import com.learning.model.OrderResponse;

@Component
public class Convertor {

	public OrderEntity requestToEntity(OrderRequest orderRequest) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setProductName(orderRequest.getProductName());
		orderEntity.setPaymentMode(orderRequest.getPaymentMode());
		orderEntity.setProductPrice(orderRequest.getProductPrice());
		orderEntity.setQuantity(orderRequest.getQuantity());
		orderEntity.setDiscount(orderRequest.getDiscount());
		orderEntity.setTotal(orderRequest.getTotal());
		orderEntity.setDate(orderRequest.getDate());
		orderEntity.setBillNumber(orderRequest.getBillNumber());
		orderEntity.setCustomerId(orderRequest.getCustomerId());
		orderEntity.setProductId(orderRequest.getProductId());
		return orderEntity;
	}

	public OrderResponse entityToResponse(OrderEntity orderEntity) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderEntity.getOrderId());
		orderResponse.setProductId(orderEntity.getProductId());
		orderResponse.setProductName(orderEntity.getProductName());
		orderResponse.setPaymentMode(orderEntity.getPaymentMode());
		orderResponse.setProductPrice(orderEntity.getProductPrice());
		orderResponse.setQuantity(orderEntity.getQuantity());
		orderResponse.setDiscount(orderEntity.getDiscount());
		orderResponse.setTotal(orderEntity.getTotal());
		orderResponse.setDate(orderEntity.getDate());
		orderResponse.setBillNumber(orderEntity.getBillNumber());
		orderResponse.setCustomerId(orderEntity.getCustomerId());
		return orderResponse;
	}

	public OrderEntity updateEntity(OrderRequest orderRequest, OrderEntity orderEntity) {
		orderEntity.setProductName(orderRequest.getProductName());
		orderEntity.setPaymentMode(orderRequest.getPaymentMode());
		orderEntity.setProductPrice(orderRequest.getProductPrice());
		orderEntity.setQuantity(orderRequest.getQuantity());
		orderEntity.setDiscount(orderRequest.getDiscount());
		orderEntity.setTotal(orderRequest.getTotal());
		orderEntity.setDate(orderRequest.getDate());
		orderEntity.setBillNumber(orderRequest.getBillNumber());
		return orderEntity;
	}


}
