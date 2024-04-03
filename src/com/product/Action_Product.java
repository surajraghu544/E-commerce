package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.admin.*;
import com.user.*;

public class Action_Product {
	public void addcart() throws Throwable {
		ConnectionTest con = new ConnectionTest();

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id no which itom you want add cart=");
			int id = sc.nextInt();

			Connection connection = con.getConnectionDetails();
			Statement stmt = connection.createStatement();
			String prod = "select * from product ";
			ResultSet crdata = stmt.executeQuery(prod);
			int no = id;
			String name = "";
			String description = "";
			int price = 0;
			int Pquantity = 0;
			int pid = 0;
			int idVerify = 0;
			while (crdata.next()) {

				if (no == crdata.getInt(1)) {
					idVerify++;
					name = name + crdata.getString(2);
					description = description + crdata.getString(3);
					price = price + crdata.getInt(4);
					Pquantity = Pquantity + crdata.getInt(5);
					pid = pid + crdata.getInt(1);
				}

			}

			if (idVerify == 1) {
				System.out.println("Enter How many Products you want to Buy");
				int quantity = sc.nextInt();
				if (quantity <= Pquantity && quantity > 0) {
					int ActPrice = (price * quantity);
					PreparedStatement pps = connection.prepareStatement(
							"insert into cart( product_id,name, description, price, quantity)values(?,?,?,?,?)");
					pps.setInt(1, pid);
					pps.setString(2, name);
					pps.setString(3, description);
					pps.setInt(4, ActPrice);
					pps.setInt(5, quantity);
					pps.executeUpdate();
					System.out.println("product added to cart successfullY..!");
					PreparedStatement pu = connection.prepareStatement("update product set quantity =? where id= ? ");
					int quReplace = Pquantity - quantity;
					pu.setInt(1, quReplace);
					pu.setInt(2, id);
					pu.executeUpdate();

					userSelection us = new userSelection();
					us.selectInput();
				} else {
					System.err.println("Sorry...! This Product Not Available in= " + quantity + " Qty. Please Buy up to = "
							+ Pquantity + " Qty. ");
					System.out.println("Redirecting to Home page");
					userSelection us = new userSelection();
					us.selectInput();
				}
			} else {
				System.err.println("Invalid Selection...! Try again");
				Inavalid_Selection ivs = new Inavalid_Selection("Invalid Selection...! Try again");
				throw ivs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println(t);
			Action_Product at = new Action_Product();
			at.addcart();
		}
	}

}
