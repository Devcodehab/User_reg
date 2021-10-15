package com.user_app_demo_1.models;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
	private Connection con;
	private Statement stmnt;
	private ResultSet result;

	public boolean verifyLogin(String emailid, String password, Connection con) {
		try {
			stmnt = con.createStatement();
			result = stmnt.executeQuery(
					"Select * from login where emailid='" + emailid + "' and password='" + password + "'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}
}
