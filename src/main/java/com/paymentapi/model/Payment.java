package com.paymentapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ecommerce_payments")
public class Payment{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="total_amount")
	private long totalAmount;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="purchased_on")
	private LocalDateTime purchasedOn;
	
	@Column(name="payment_mode")
	private String paymentMode;

}
