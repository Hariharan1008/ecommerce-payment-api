package com.paymentapi.bank.verifycards.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paymentapi.bank.verifycards.model.BankDetails;



public interface PaymentRepositoryForBank extends JpaRepository<BankDetails, Integer> {

	BankDetails findByCardNumber(long cardNumber);

	BankDetails findByMonthAndCardNumber(int month, long cardNumber);

	BankDetails findByCvv(int cvv);

	BankDetails findByYearAndCardNumber(int year, long cardNumber);

	@Transactional
	@Modifying
	@Query("update com.paymentapi.bank.verifycards.model.BankDetails u set u.accountBalance=:accountBalance where u.cardNumber=:cardNumber")
	void changeAmount(@Param("accountBalance") long accountBalance, @Param("cardNumber") long cardNumber);

}
