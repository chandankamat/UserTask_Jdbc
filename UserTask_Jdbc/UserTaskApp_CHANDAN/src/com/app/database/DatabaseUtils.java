package com.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public  class DatabaseUtils 
{
	private final String dbUrl = "jdbc:mysql://localhost:3306/usersdb";
	private final String dbUsername = "root";
	private final String dbPassword = "kumar123";
	
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement statement= null;
	
	public void connect() {
		try
		{
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); // open connection
			System.out.println("Connected to MySQL DB");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void disConnect() {
		try
		{
			con.close();// close connection
			System.out.println("DisConnected from MySQL DB");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

		

