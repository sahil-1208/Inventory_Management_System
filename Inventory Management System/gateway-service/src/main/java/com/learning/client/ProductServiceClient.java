package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.enums.Status;
import com.learning.model.ProductRequest;
import com.learning.model.ProductResponse;

@FeignClient(value = "ProductServiceClient", url = "http://localhost:8093/product")
public interface ProductServiceClient {

	@PostMapping
	public ProductResponse postProduct(@RequestBody ProductRequest productRequest);

	@GetMapping("/{productId}")
	public ProductResponse getByProductId(@PathVariable Long productId);

	@PutMapping("/{productId}")
	public ProductResponse updateProductById(@PathVariable Long productId, @RequestBody ProductRequest productRequest);

	@DeleteMapping("/{productId}")
	public Status deleteById(@PathVariable Long productId);
	
}
