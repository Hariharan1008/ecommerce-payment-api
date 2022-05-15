package com.paymentapi.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paymentapi.dao.WalletBalanceUpdator;
import com.paymentapi.dao.WalletRepository;
import com.paymentapi.dao.WalletTransactionRepository;
import com.paymentapi.model.Wallet;
import com.paymentapi.model.WalletTransaction;

@Component
public class WalletService {
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	WalletTransactionRepository transactionRepository;
	
	@Autowired
	WalletBalanceUpdator updateBalance;
	
   public int createWallet(Wallet wallet) throws Exception
   {
	   wallet.setBalance(0);
	   Wallet user=walletRepository.save(wallet);
	   if(user!=null)
	   {
		   return 1;
	   }
	   else
	   {
		   throw new Exception("can not process your request at this time");
	   }
   }
   
   public long findWalletBalnce(long mobile)
   {
	   long balance=walletRepository.getWalletBalanceUsingMobile(mobile);
	   return balance;
	   
   }
   
   public int updateWalletAddBalance(long mobile,long amount) throws ClassNotFoundException, SQLException
   {
	   long existingBalance=walletRepository.getWalletBalanceUsingMobile(mobile);
	   long updatedBalance=existingBalance+amount;
	   int updated=updateBalance.updateWalletBalance(mobile, updatedBalance);
	  // walletRepository.updateWalletBalance(updatedBalance, mobile);
	   WalletTransaction transaction=new  WalletTransaction();
	   transaction.setMobile(mobile);
	   transaction.setOperation("credited");
	   transaction.setPurpose("to increase wallet balance");
	   transaction.setAmount(amount);
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();
	   transaction.setPurchasedOn(now);
	   transactionRepository.save(transaction);
	   return 1;
	   
   }
   
   public int updateWalletSubtractMoney(long mobile,long amount) throws ClassNotFoundException, SQLException
   {
	   long existingBalance=walletRepository.getWalletBalanceUsingMobile(mobile);
	   long updatedBalance=existingBalance-amount;
	   int updated=updateBalance.updateWalletBalance(mobile, updatedBalance);
//	   //walletRepository.updateWalletBalance(updatedBalance, mobile);
	   WalletTransaction transaction=new  WalletTransaction();
	   transaction.setMobile(mobile);
	   transaction.setOperation("debited");
	   transaction.setPurpose("to shopping");
	   transaction.setAmount(amount);
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();
	   transaction.setPurchasedOn(now);
	   transactionRepository.save(transaction);
	   return 1;
   }
   
   public int verifyTpin(int tpin,long mobile) throws Exception
   {
	   int pin=walletRepository.getTransactionPin(mobile);
	   if(pin==tpin)
	   {
		   return 1;
	   }
	   else
	   {
		   throw new Exception("invalid transaction pin");
	   }
   }
   
   public int verifyWalletBalance(long mobile,long amount) throws Exception
   {
	   long existingBalance=walletRepository.getWalletBalanceUsingMobile(mobile);
	   if(amount<=existingBalance)
	   {
		   return 1;
	   }
	   else
	   {
		   throw new Exception("Insufficient funds");
	   }
   }
  public int updateUserTransactionPin(long mobile,int tpin)
  {
	  walletRepository.updateTransactionPin(tpin, mobile);
	  return 1;
  }
   
}
