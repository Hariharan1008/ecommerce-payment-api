package com.paymentapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentapi.model.WalletTransaction;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Integer> {

}
