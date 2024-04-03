package com.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.*;

public class All_User_Data {
	public void getUserData() throws Throwable {
		ConnectionTest ct = new ConnectionTest();
		try {
			Connection con = ct.getConnectionDetails();
			Statement stmt = con.createStatement();
			ResultSet rd = stmt.executeQuery("select * from userlogin");
			while (rd.next()) {
				System.out.println("sr no           =       " + rd.getInt(1));
				System.out.println();
				System.out.println("User First Name =       " + rd.getString(2));
				System.out.println();
				System.out.println("User Last Name  =        " + rd.getString(3));
				System.out.println();
				System.out.println("User Log In Id  =        " + rd.getString(4));
				System.out.println();
				System.out.println("User Password   =        " + rd.getString(5));
				System.out.println();
				System.out.println("User Email      =        " + rd.getString(6));
				System.out.println();
				System.out.println("User Mobile No    =       " + rd.getString(7));
				System.out.println();
				System.out.println("User Address    =         " + rd.getString(8));
				System.out.println();
				System.out.println("*********************************************");
			}
			Admin_Control ac = new Admin_Control();
			ac.tocontroladmin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
