package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public String driver = "com.mysql.jdbc.Driver";
	public String url = "jdbc:mysql://localhost:3307/library";
	public String username = "root";
	public String password = "admin";

	
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(Boolean.FALSE);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
