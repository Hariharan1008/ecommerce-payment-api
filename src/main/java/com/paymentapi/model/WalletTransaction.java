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
@Entity(name="ecommerce_wallet_transactions")
public class WalletTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="operation")
	private String operation;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="purchased_on")
	private LocalDateTime purchasedOn;
	
	@Column(name="amount")
	private long amount;

}
