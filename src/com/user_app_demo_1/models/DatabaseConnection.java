package com.user_app_demo_1.models;

import java.sql.*;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection con;

	public Connection establishConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_app_demo", "root", "pankaj");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
