package com.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.ConnectionTest;
import com.user.*;

public class ProductDataUser {
	public void productData() throws Throwable {

		ConnectionTest con = new ConnectionTest();

		try {
			Connection connection = con.getConnectionDetails();
			Statement stmt = connection.createStatement();
			String read = "select * from product";
			ResultSet rd = stmt.executeQuery(read);
			while (rd.next()) {
				Thread.sleep(1000);
				System.out.println("Poduct id =           " + rd.getInt(1));
				System.out.println();
				System.out.println("Product Name =        " + rd.getString(2));
				System.out.println();
				System.out.println("Product Description = " + rd.getString(3));
				System.out.println();
				System.out.println("Product Price =        " + rd.getInt(4));
				System.out.println();
				System.out.println("*********************************************");
			}
			userSelection us = new userSelection();
			us.selectInput();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}