package com.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.ConnectionTest;
import com.user.*;

public class Ascending_product {

	public void getAscending() throws Throwable {
		ConnectionTest ct = new ConnectionTest();
		try {
			Connection connection = ct.getConnectionDetails();
			Statement stmt = connection.createStatement();
			ResultSet asc = stmt.executeQuery("select * from product order by price asc");
			int count = 0;
			while (asc.next()) {
				count++;
				
				System.out.println("Poduct id =           " + asc.getInt(1));
				System.out.println();
				System.out.println("Product Name =        " + asc.getString(2));
				System.out.println();
				System.out.println("Product Description = " + asc.getString(3));
				System.out.println();
				System.out.println("Product Price =        " + asc.getInt(4));
				System.out.println();
				System.out.println("Product Quantity =     " + asc.getInt(5));
				System.out.println();
				System.out.println("*********************************************");
			}
			userSelection us = new userSelection();
			us.selectInput();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
