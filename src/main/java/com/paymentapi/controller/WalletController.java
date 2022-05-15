package com.paymentapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentapi.dto.Message;
import com.paymentapi.model.Wallet;
import com.paymentapi.service.WalletService;

@RestController
public class WalletController {
	@Autowired
	WalletService walletService;
	
	@PostMapping("wallet/user/register")
	public ResponseEntity<?> walletRegistration(@RequestBody Wallet wallet)
	{
		try
		{
			int created=walletService.createWallet(wallet);
			if(created==1)
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
	
	@GetMapping("wallet/user/find/balance")
	public ResponseEntity<?> getWalletBalance(@RequestParam("mobile") long mobile)
	{
		try
		{
			long balance=walletService.findWalletBalnce(mobile);
		    Message message=new Message();
			message.setBalance(balance);
			return new ResponseEntity<>(message,HttpStatus.OK);
		  }
		  catch(Exception e)
		  {
			  Message message=new Message();
			  message.setMessage(e.getMessage());
			  return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		  }
	}
	
	@GetMapping("wallet/user/balance/updation/add")
	public ResponseEntity<?> updateWalletBalance(@RequestParam("mobile") long mobile,@RequestParam("amount") long amount)
	{
		try
		{
			System.out.println(mobile+""+amount);
			int added=walletService.updateWalletAddBalance(mobile, amount);
			return new ResponseEntity<>(HttpStatus.OK);	
		}
		 catch(Exception e)
		  {
			  Message message=new Message();
			  message.setMessage(e.getMessage());
			  return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		  }
	}
	
	@PostMapping("wallet/tpin/verification")
	public ResponseEntity<?> verifyTransactionPin(@RequestBody Wallet wallet)
	{
		try
		{
			int valid=walletService.verifyTpin(wallet.getTransactionPin(), wallet.getMobile());
		    if(valid==1)
		    {
			    return new ResponseEntity<>(HttpStatus.OK);
		    }
		    else
		    {
		    	  Message message=new Message();
				  message.setMessage("can not process your request at this time");
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
	
	@GetMapping("wallet/user/verify/balance")
	public ResponseEntity<?> verfifyWalletBalance(@RequestParam("mobile") long mobile,@RequestParam("amount") long amount)
	{
		try
		{
			int valid=walletService.verifyWalletBalance(mobile, amount);
		    if(valid==1)
		    {
			    return new ResponseEntity<>(HttpStatus.OK);
		    }
		    else
		    {
		    	  Message message=new Message();
				  message.setMessage("can not process your request at this time");
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
	
	
	
	@GetMapping("wallet/user/balance/updation/subtract")
	public ResponseEntity<?> subtractWalletBalance(@RequestParam("mobile") long mobile,@RequestParam("amount") long amount)
	{
		try
		{
			int added=walletService.updateWalletSubtractMoney(mobile, amount);
			return new ResponseEntity<>(HttpStatus.OK);	
		}
		 catch(Exception e)
		  {
			  Message message=new Message();
			  message.setMessage(e.getMessage());
			  return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		  }
	}
	
	@PostMapping("wallet/user/update/tpin")
	public ResponseEntity<?> updateTransactionPin(@RequestBody Wallet wallet)
	{
		try
		{
			int updated=walletService.updateUserTransactionPin(wallet.getMobile(), wallet.getTransactionPin());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			 Message message=new Message();
			 message.setMessage(e.getMessage());
			 return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
