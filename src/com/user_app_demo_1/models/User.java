package com.user_app_demo_1.models;

import java.sql.*;

public class User {
	private Statement stmnt;

	public void addRegistration(String firstName, String lastName, String emailId, String city, String country,
			Connection con) {
		try {
			stmnt = con.createStatement();
			stmnt.executeUpdate("insert into registration values('" + firstName + "','" + lastName + "','" + emailId
					+ "','" + city + "','" + country + "')");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public ResultSet showRegistration(Connection con) {
		try {
			Statement stmnt = con.createStatement();
			ResultSet results = stmnt.executeQuery("select * from registration");
			return results;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

	public void deleteReg(String emailid, Connection con) {
		try {
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate("DELETE FROM registration WHERE emailid='" + emailid + "'");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void updateReg(String emailid, String city, Connection con) {
		try {
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate("UPDATE registration SET city = '" + city + "' WHERE emailid='" + emailid + "'");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
