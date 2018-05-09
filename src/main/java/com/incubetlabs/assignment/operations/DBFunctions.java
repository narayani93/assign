package com.incubetlabs.assignment.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.incubetlabs.assignment.database.DBConnection;
import com.incubetlabs.assignment.model.Hotel;

public class DBFunctions {
	public static boolean saveToDatabase(Hotel hotel) {
		DBConnection conn = DBConnection.getDBConnectionInstance();
	    Connection c = conn.getConnected();
	    
	    String sql = "INSERT INTO hotel(name, address, city) VALUES(?,?,?)";
	    int count = 0;
	    try {
	    	PreparedStatement preparedStmt = c.prepareStatement(sql);
	    	preparedStmt.setString(1, hotel.getName());
	    	preparedStmt.setString(2, hotel.getAddress());
	    	preparedStmt.setString(3, hotel.getCity());
		    count = conn.getInsertQueryResults(preparedStmt);
	    }
	    catch(SQLException e) {
	    	System.out.println(e);
	    }
	    
	    
	    conn.closeConnection(c);
	    
	    if(count > 0){
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	public static List<Hotel> getSearchDetails(String city) {
		DBConnection conn = DBConnection.getDBConnectionInstance();
	    Connection c = conn.getConnected();
	    
	    String sql = "SELECT name, address FROM hotel WHERE city = ?";
	    ResultSet rs = null;
	    List<Hotel> ll = new LinkedList<Hotel>();
	    try {
	    	PreparedStatement preparedStmt = c.prepareStatement(sql);
	    	preparedStmt.setString(1, city);
	    	rs = conn.getSelectQueryResults(preparedStmt, sql);
	    	while (rs.next()) {
	    		Hotel h = new Hotel();
	    		h.setName(rs.getString("name"));
	    		h.setAddress(rs.getString("address"));
	    		ll.add(h);
    		}
	    }
	    catch(SQLException e) {
	    	System.out.println(e);
	    }
	    
	    conn.closeConnection(c);
	    
	    return ll;
	}
}
