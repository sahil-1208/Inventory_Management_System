package com.learning.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.learning.enums.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ORDER_DETAILS" )
public class OrderEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "orderId") 
    private Long orderId;
	
	
	//@Column(name = "productId")
	private Long productId;
	
	//@Column(name ="productName")
	private String productName;
	
	@Enumerated(EnumType.STRING)
	//@Column(name ="paymentMode")
	private PaymentMode paymentMode;
	
	//@Column(name ="productPrice")
	private Long productPrice;
	
	//@Column(name ="quantity")
	private Long quantity;
	
	//@Column(name ="discount")
	private Long discount;
	
	//@Column(name ="total")
	private Double total;
	
	//@Column(name ="date")
	private LocalDate date;
	
	//@Column(name ="billNumber")
	private String billNumber;
	
	//@Column(name ="customerId")
	private Long customerId;

}
