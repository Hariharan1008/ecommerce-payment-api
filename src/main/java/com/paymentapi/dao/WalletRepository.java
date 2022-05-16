package com.paymentapi.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paymentapi.model.Wallet;
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Integer> {
	
	@Query("select u.balance from com.paymentapi.model.Wallet u where u.mobile=:mobile")
	long getWalletBalanceUsingMobile(@Param("mobile") long mobile);
	
	@Transactional
	@Modifying
	@Query("update com.paymentapi.model.Wallet u set u.balance=:balance where u.mobile=:mobile")
	void updateWalletBalance(@Param("balance") long balance,@Param("mobile") long mobile);
   
	@Query("select u.transactionPin from com.paymentapi.model.Wallet u where u.mobile=:mobile")
	int getTransactionPin(@Param("mobile") long mobile);
	
	@Transactional
	@Modifying
	@Query("update com.paymentapi.model.Wallet u set u.transactionPin=:tpin where u.mobile=:mobile")
    void updateTransactionPin(@Param("tpin") int tpin,@Param("mobile") long mobile);
	
	@Query("select u from com.paymentapi.model.Wallet u where u.mobile=:mobile")
	Wallet getWalletDetails(@Param("mobile") long mobile);
	
	
	
}
