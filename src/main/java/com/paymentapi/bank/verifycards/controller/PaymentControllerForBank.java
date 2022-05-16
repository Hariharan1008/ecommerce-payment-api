package com.paymentapi.bank.verifycards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paymentapi.bank.verifycards.dto.Message;
import com.paymentapi.bank.verifycards.model.BankDetails;
import com.paymentapi.bank.verifycards.service.PaymentServiceForBank;



@RestController
public class PaymentControllerForBank {

	@Autowired
	PaymentServiceForBank paymentService;

	@PostMapping("payment/verifycards")
	public ResponseEntity verifyCadrs(@RequestBody BankDetails details) {

		try {
			Message message = new Message(paymentService.verifyDetails(details.getCardNumber(), details.getMonth(),
					details.getYear(), details.getCvv(), details.getAmount()));
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

	}
	
	

	
	

}
