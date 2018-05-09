package com.incubetlabs.assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection conn;
	
	private DBConnection() {
		
	}
	
	public static DBConnection getDBConnectionInstance() {
		if(conn == null) {
			conn = new DBConnection();
		}
		return conn;
	}
	
	public Connection getConnected() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel1","root","");
		}
		catch(ClassNotFoundException e) {
			System.out.print(e);
		}
		catch(SQLException e) {
			System.out.print(e);
		}
		return con;
	}
	
	public int getInsertQueryResults(PreparedStatement query) {
		int count = 0;
		try {
			count = query.executeUpdate();
		}
		catch(SQLException e) {
			System.out.print(e);
		}
		return count;
	}
	
	public ResultSet getSelectQueryResults(PreparedStatement preparedStmt, String query) {
		ResultSet rs = null;
		try {
			rs = preparedStmt.executeQuery();
		}
		catch(SQLException e) {
			System.out.print(e);
		}
		return rs;
	}
	
	public void closeConnection(Connection c) {
		try {
			c.close();
		}
		catch(SQLException e) {
			System.out.print(e);
		}	
	}

}
