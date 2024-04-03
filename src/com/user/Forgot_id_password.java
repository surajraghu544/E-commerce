package com.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.admin.ConnectionTest;

public class Forgot_id_password {
	public void getIDpassword() throws Throwable {
		ConnectionTest con = new ConnectionTest();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Mobile No  = ");
		String loginid = sc.next();

		try {
			Connection connection = con.getConnectionDetails();
			String relog = "select * from userlogin";
			Statement st = connection.createStatement();
			ResultSet logdata = st.executeQuery(relog);
			int count = 0;
			while (logdata.next()) {
				String logdb = logdata.getString(7);
				if (loginid.equals(logdb)) {
					count++;
					System.out.println("welcome " + logdata.getString(2) + " " + logdata.getString(3));
					System.out.println("Your Login id = " + logdata.getString(4));
					System.out.println("Your Password is =" + logdata.getString(5));
					Userlogin p = new Userlogin();
					p.logincheck();

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
