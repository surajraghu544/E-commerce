package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminProductTable {
	public void productData() throws Throwable {

		ConnectionTest con = new ConnectionTest();

		try {
			Connection connection = con.getConnectionDetails();
			Statement stmt = connection.createStatement();
			String read = "select * from product";
			ResultSet rd = stmt.executeQuery(read);
			while (rd.next()) {
				// Thread.sleep(2000);
				// System.out.println(rd.getInt(1)+" "+rd.getString(2)+" "+rd.getString(3)+"
				// "+rd.getInt(4)+" "+rd.getInt(5));
				System.out.println("Poduct id =           " + rd.getInt(1));
				System.out.println();
				System.out.println("Product Name =        " + rd.getString(2));
				System.out.println();
				System.out.println("Product Description = " + rd.getString(3));
				System.out.println();
				System.out.println("Product Price =        " + rd.getInt(4));
				System.out.println();
				System.out.println("Product Quantity =     " + rd.getInt(5));
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