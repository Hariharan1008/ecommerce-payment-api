package com.paymentapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class WalletBalanceUpdator {
	
	public int updateWalletBalance(long mobile,long amount) throws SQLException, ClassNotFoundException
	{
		Connection connection=ConnectionUtil.databaseConnection();
		PreparedStatement statement=null;
		String query="update ecommerce_wallet set balance=? where mobile=?";
		statement=connection.prepareStatement(query);
		statement.setLong(1, amount);
		statement.setLong(2, mobile);
		int rows=statement.executeUpdate();
		connection.close();
		return rows;
	}

}
