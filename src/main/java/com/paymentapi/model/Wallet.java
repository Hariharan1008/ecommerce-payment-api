package com.paymentapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ecommerce_wallet")
public class Wallet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="name")
	private String name;
	
	@Column(name="balance")
	private long balance;
	
	@Column(name="tpin")
	private int transactionPin;
}
