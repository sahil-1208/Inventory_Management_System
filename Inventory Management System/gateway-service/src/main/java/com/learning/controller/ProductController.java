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

import com.learning.client.ProductServiceClient;
import com.learning.enums.Status;
import com.learning.model.ProductRequest;
import com.learning.model.ProductResponse;

@RestController
@RequestMapping("/api/product/v1")
public class ProductController {

	@Autowired
	private ProductServiceClient productServiceClient;

	@PostMapping
	public ProductResponse postProduct(@RequestBody ProductRequest productRequest) {
		return productServiceClient.postProduct(productRequest);
	}

	@GetMapping("/{productId}")
	public ProductResponse getByProductId(@PathVariable Long productId) {
		return productServiceClient.getByProductId(productId);
	}

	@PutMapping("/{productId}")
	public ProductResponse updateProductById(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {
		return productServiceClient.updateProductById(productId, productRequest);
	}

	@DeleteMapping("/{productId}")
	public Status deleteById(@PathVariable Long productId) {
		return productServiceClient.deleteById(productId);
	}
}
