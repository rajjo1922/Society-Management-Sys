package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements Provider {
	public static Connection connection;

	// getConnection() to get mysql Connection
	public static Connection getConnection() {
		try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gangakunj_app", "root", "Rajjo@123");
			
			System.out.println("Connection is success...");
		} catch (Exception ex) {
			System.out.println("Exception DB.java Connection Time : " + ex.getMessage());
		}
		return connection;
	}
	
	public static boolean closeConnection(Connection con) {
		boolean isValid = false;
		try {
			con.close();
//    		System.out.println("Connection is close successfully...");
		} catch (Exception ex) {
			System.out.println("Exception  closeConnection() : DB.java : " + ex.getMessage());
		}
		return isValid;
	}
}
