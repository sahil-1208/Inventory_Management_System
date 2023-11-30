package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Long> {

	Optional<SupplierEntity> findBySupplierId(Long supplierId);

}
