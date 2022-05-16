package com.paymentapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paymentapi.model.WalletTransaction;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Integer> {

	
	@Query("select u from com.paymentapi.model.WalletTransaction u where u.mobile=:mobile")
	List<WalletTransaction> getAllTransactions(@Param("mobile") long mobile);
}
