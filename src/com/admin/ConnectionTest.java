package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	Connection cone = null;

	public Connection getConnectionDetails() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "raghu");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return cone;
	}
}
