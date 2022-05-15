package com.paymentapi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paymentapi.dao.PaymentRepository;
import com.paymentapi.model.Payment;


@Component
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	public int updatePaymentTransaction(Payment payment) throws Exception
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();
		 payment.setPurchasedOn(now);
	    Payment paid=paymentRepository.save(payment);
		if(paid!=null)
		{
			return 1;
		}
		else
		{
			throw new Exception("cannot process this transaction");
		}
	}
	
	
}
