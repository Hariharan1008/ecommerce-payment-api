package com.paymentapi.bank.verifycards.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paymentapi.bank.verifycards.dao.PaymentRepositoryForBank;
import com.paymentapi.bank.verifycards.dao.TransactionRepository;
import com.paymentapi.bank.verifycards.model.BankDetails;
import com.paymentapi.bank.verifycards.model.PaymentTransaction;

@Component
public class PaymentServiceForBank {

	@Autowired
	PaymentRepositoryForBank paymentRepository;

	@Autowired
	TransactionRepository object;

	public String verifyDetails(long cardNumber, int month, int year, int cvv, long amount) throws Exception {

		BankDetails obj = paymentRepository.findByCardNumber(cardNumber);

		if (obj == null) {
			throw new Exception("Invalid Card Number");
		} else {
			BankDetails row = paymentRepository.findByMonthAndCardNumber(month, cardNumber);
			if (row == null) {
				throw new Exception("Invalid month");
			} else {
				BankDetails row2 = paymentRepository.findByYearAndCardNumber(year, cardNumber);
				if (row2 == null) {
					throw new Exception("Invalid year");
				} else {
					BankDetails row1 = paymentRepository.findByCvv(cvv);
					if (row1 == null) {
						throw new Exception("Invalid CVV");
					} else {
						long userbalance = obj.getAccountBalance();
						if (userbalance < amount) {
							throw new Exception("Insufficient Account balance");
						} else {
							LocalDateTime timestamp = LocalDateTime.now();
							String time = timestamp.toString();
							long totalbalance = userbalance - amount;
							paymentRepository.changeAmount(totalbalance, cardNumber);
							PaymentTransaction transaction = new PaymentTransaction();
							System.out.println(amount);
							transaction.setName(obj.getName());
							transaction.setUserAccountNumber(obj.getAccountNumber());
							transaction.setCardNumber(cardNumber);
							transaction.setAmount(amount);
							transaction.setType("Card Payment");
							transaction.setCurrentBalance(totalbalance);
							transaction.setDateTime(time);

							PaymentTransaction object2 = object.save(transaction);

							if (object2 == null) {
								throw new Exception("Transaction Failed");
							} else {
								return "Payment Success";
							}
						}
					}
				}
			}
		}

	}

	

}
