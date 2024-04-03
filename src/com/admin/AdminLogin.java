package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLogin {
	public void adminlogin() throws Throwable {
		ProductPage product = new ProductPage();
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter admin Login id = ");
			String Login_id = sc.next();
			System.out.println("Enter admin Password = ");
			String pass = sc.next();
			ConnectionTest ct = new ConnectionTest();
			Connection con = ct.getConnectionDetails();
			Statement stmt = con.createStatement();
			ResultSet rd = stmt.executeQuery("select * from admin");
			int count = 0;
			while (rd.next()) {

				String logid = rd.getString(4);
				String pssword = rd.getString(5);
				if (Login_id.equals(logid) && (pass.equals(pssword))) {
					System.out.println("WelCome...." + rd.getString(2) + " " + rd.getString(3));
					count++;
					Admin_Control p = new Admin_Control();
					p.tocontroladmin();
				}
			}

			if (count == 0) {
				System.err.println("Invalid Login id OR Password....!..Retry");
				InvalidUseridOrPassword ivp = new InvalidUseridOrPassword("Invalid Login id OR Password....!");
				throw ivp;
			}

		} catch (Throwable e) {
			System.out.println(e);
			AdminLogin a = new AdminLogin();
			a.adminlogin();
		}

	}
}