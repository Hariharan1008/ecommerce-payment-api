package com.paymentapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paymentapi.dto.Message;
import com.paymentapi.model.Payment;
import com.paymentapi.service.PaymentService;

@RestController
public class PaymentController {
	 @Autowired
	 PaymentService cardSevice;
	 
	@PostMapping("payment/service/success")
	public ResponseEntity<?> updateSuccessTransaction(@RequestBody Payment payment)
	{
		try
		{
			payment.setPaymentStatus("success");
			int updated=cardSevice.updatePaymentTransaction(payment);
			if(updated==1)
			{
				  return new ResponseEntity<>(HttpStatus.OK);
			  }
			  else
			  {
				  com.paymentapi.dto.Message message=new Message();
				  message.setMessage("can not process your request this time");
				  return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
			  } 
		  }
		  catch(Exception e)
		  {
			  Message message=new Message();
			  message.setMessage(e.getMessage());
			  return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		  }
	}
	
	@PostMapping("payment/service/failed")
	public ResponseEntity<?> updateFailedTransaction(@RequestBody Payment payment)
	{
		try
		{
			payment.setPaymentStatus("pending");
			int updated=cardSevice.updatePaymentTransaction(payment);
			if(updated==1)
			{
				  return new ResponseEntity<>(HttpStatus.OK);
			  }
			  else
			  {
				  com.paymentapi.dto.Message message=new Message();
				  message.setMessage("can not process your request this time");
				  return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
			  } 
		  }
		  catch(Exception e)
		  {
			  Message message=new Message();
			  message.setMessage(e.getMessage());
			  return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		  }
	}

}
