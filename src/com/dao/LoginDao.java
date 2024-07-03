package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.bean.LoginBean;
import com.util.DBConnection;

public class LoginDao {

	public String authenticateUser(LoginBean loginBean)
	{
		String username = loginBean.getUsername(); //Keeping user entered values in temporary variables.
		String password = loginBean.getPassword();
//		String password ="123";
		
		Connection con = null ;
		Statement statement = null;
		ResultSet resultSet = null;
		String usernameDB;
		String passwordDB;
	
		try
		{
				con = DBConnection.getConnection(); //establishing connection
				statement = con.createStatement(); //Statement is used to write queries. Read more about it.
				resultSet = statement.executeQuery("select username,password from users"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
				
				while(resultSet.next()) // Until next row is present otherwise it return false
				{
					usernameDB = resultSet.getString("username"); //fetch the values present in database
					passwordDB = resultSet.getString("password");
//					System.out.println(usernameDB);
//					System.out.println(passwordDB);
//					System.out.println(username);
//					System.out.println(password);
					if(username.equals(usernameDB) && password.equals(passwordDB))
					{
						return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
					}
				}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials"; // Just returning appropriate message otherwise
	}
}

