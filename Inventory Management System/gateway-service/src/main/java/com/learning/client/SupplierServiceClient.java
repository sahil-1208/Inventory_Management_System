package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.enums.Status;
import com.learning.model.SupplierRequest;
import com.learning.model.SupplierResponse;

@FeignClient(value = "SupplierServiceClient" , url = "http://localhost:8092/supplier"  )
public interface SupplierServiceClient {

	@PostMapping
	public SupplierResponse postSupplier(@RequestBody SupplierRequest supplierRequest);
	@GetMapping("/{supplierId}")
	public SupplierResponse getBySupplierId(@PathVariable Long supplierId);

	@PutMapping("/{supplierId}")
	public SupplierResponse updateSupplier(@PathVariable Long supplierId, @RequestBody SupplierRequest supplierRequest);

	@DeleteMapping("/{supplierId}")
	public Status deleteSupplier(@PathVariable Long supplierId);
}
