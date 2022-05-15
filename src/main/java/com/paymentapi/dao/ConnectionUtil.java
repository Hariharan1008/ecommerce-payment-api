package com.paymentapi.dao;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection databaseConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://hariharan-db.cdbky3odmgvg.ap-south-1.rds.amazonaws.com/hariharan_db","hariharan","Hari1008");
	return connection;
	}
	


}
