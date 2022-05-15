package com.paymentapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paymentapi.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	

}
