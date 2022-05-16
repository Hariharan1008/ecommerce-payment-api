package com.paymentapi.bank.verifycards.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "bank_details")
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_number")
	private long cardNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "account_number")
	private long accountNumber;

	@Column(name = "ifsc_code")
	private long ifscCode;

	@Column(name = "month")
	private int month;

	@Column(name = "year")
	private int year;

	@Column(name = "cvv")
	private int cvv;

	@Column(name = "account_balance")
	private long accountBalance;

	@Column(name = "bank_name")
	private String bankname;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "requested_amount")
	private int amount;

}