package com.learning.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.SupplierEntity;
import com.learning.enums.Status;
import com.learning.globalException.SupplierResponseException;
import com.learning.model.SupplierRequest;
import com.learning.model.SupplierResponse;
import com.learning.repository.SupplierRepository;
import com.learning.utils.Convertor;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private Convertor convertor;

	public SupplierResponse createSupplier(SupplierRequest supplierRequest) {
		SupplierResponse supplierResponse = null;
		if (Objects.nonNull(supplierRequest)) {
			SupplierEntity supplierEntity = convertor.requestToEntity(supplierRequest);
			supplierEntity = supplierRepository.save(supplierEntity);
			supplierResponse = convertor.entityToResponse(supplierEntity);
		}
		return supplierResponse;
	}

	public SupplierResponse findBySupplierId(Long supplierId) {
		Optional<SupplierEntity> supplierEntityOptional = supplierRepository.findBySupplierId(supplierId);
		if (supplierEntityOptional.isPresent()) {
			SupplierEntity supplierEntity = supplierEntityOptional.get();
			return convertor.entityToResponse(supplierEntity);
		} else {
			throw new SupplierResponseException("Supplier not found for ID: " + supplierId);
		}
	}

	public SupplierResponse updateSupplier(Long supplierId, SupplierRequest supplierRequest) {
		return supplierRepository.findById(supplierId).map(supplierEntity -> {
			supplierEntity = convertor.updateEntity(supplierRequest, supplierEntity);
			supplierEntity = supplierRepository.save(supplierEntity);
			return convertor.entityToResponse(supplierEntity);
		}).orElseThrow(() -> new SupplierResponseException("Supplier Not Found"));
	}

	public Status deleteSupplier(Long supplierId) {
		Optional<SupplierEntity> optionalEntity = supplierRepository.findById(supplierId);
		if (Objects.nonNull(optionalEntity)) {
			supplierRepository.deleteById(supplierId);
			return Status.SUCCESS;
		}
		return Status.FAILED;
	}
	
}
