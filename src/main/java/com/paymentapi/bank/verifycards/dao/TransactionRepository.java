package com.paymentapi.bank.verifycards.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.paymentapi.bank.verifycards.model.PaymentTransaction;



@Component
@Repository
public interface TransactionRepository extends JpaRepository<PaymentTransaction, Integer> {

	@SuppressWarnings("unchecked")
	PaymentTransaction save(PaymentTransaction transaction);

}
