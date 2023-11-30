package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

	Optional<Customer> findByCustomerId(Long customerId);

}
