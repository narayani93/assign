package com.incubetlabs.assignment.operations;


import com.incubetlabs.assignment.database.DBConnection;
import java.sql.Connection;


public class MainJava {
	public static void main( String[] args )
		{
		    DBConnection conn = DBConnection.getDBConnectionInstance();
		    Connection c = conn.getConnected();
		    //conn.getQueryResults(c);
		    conn.closeConnection(c);
		}
}
