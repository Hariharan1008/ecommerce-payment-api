package com.paymentapi.bank.verifycards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.ToString;

//Bank

@Data
@ToString
@Component
@Entity(name = "user_transaction")
public class PaymentTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name="card_number")
	private long cardNumber;
	
	@Column(name = "user_account_number")
	private long userAccountNumber;

	@Column(name = "spended_amount")
	private long amount;

	@Column(name = "type")
	private String type;

	@Column(name = "account_number")
	private long accountNumber;

	@Column(name = "current_balance")
	private long currentBalance;

	@Column(name = "date_time")
	private String dateTime;

}
