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

import com.learning.client.SupplierServiceClient;
import com.learning.enums.Status;
import com.learning.model.SupplierRequest;
import com.learning.model.SupplierResponse;

@RestController
@RequestMapping("/api/supplier/v1")
public class SupplierController {

	@Autowired
	private SupplierServiceClient supplierServiceClient;

	@PostMapping
	public SupplierResponse postSupplier(@RequestBody SupplierRequest supplierRequest) {
		return supplierServiceClient.postSupplier(supplierRequest);
	}

	@GetMapping("/{supplierId}")
	public SupplierResponse getBySupplierId(@PathVariable Long supplierId) {
		return supplierServiceClient.getBySupplierId(supplierId);
	}

	@PutMapping("/{supplierId}")
	public SupplierResponse updateSupplier(@PathVariable Long supplierId, @RequestBody SupplierRequest supplierRequest) {
		return supplierServiceClient.updateSupplier(supplierId, supplierRequest);
	}

	@DeleteMapping("/{supplierId}")
	public Status deleteSupplier(@PathVariable Long supplierId) {
		return supplierServiceClient.deleteSupplier(supplierId);
	}
}
