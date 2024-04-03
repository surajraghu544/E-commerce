package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.main.Organiser_main;
import com.product.ProductDataUser;
import com.user.User;

public class ProductPage {
	public void isertDataProduct(String Pname, String Pdescription, int Pprice, int Pquantity) throws Throwable {

		try {
			ConnectionTest CT = new ConnectionTest();
			Connection con = CT.getConnectionDetails();
			PreparedStatement pstmt = con
					.prepareStatement("insert into product( name, description, price, quantity)values (?,?,?,?)");
			pstmt.setString(1, Pname);
			pstmt.setString(2, Pdescription);
			pstmt.setInt(3, Pprice);
			pstmt.setInt(4, Pquantity);
			pstmt.executeUpdate();
			System.out.println("Product insert succssefully...!");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 1 for add more Product");
			System.out.println("Enter 2 for Home Page ");
			System.out.println("Enter 0 for log out");
			String input = sc.next();
			switch (input) {
			case ("1"): {
				ProductPage pg = new ProductPage();
				pg.insertProduct();
			}
			case ("2"): {
				Admin_Control pc = new Admin_Control();
				pc.tocontroladmin();
			}
			case ("0"): {
				Organiser_main om = new Organiser_main();
				om.m1();
			}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			ProductPage p = new ProductPage();
			p.insertProduct();
		}

	}

	public void insertProduct() throws Throwable {

		ProductPage product = new ProductPage();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Product you want to add = ");
		int no = sc.nextInt();
		for (int i = 1; i <= no; i++) {
			System.out.println("Enter product Name = ");
			String Pname = sc.next();
			System.out.println("Enter product description = ");
			String Pdescription = sc.next();
			System.out.println("Enter price of Product = ");
			int price = sc.nextInt();
			System.out.println("Enter Quantity of Product = ");
			int quantity = sc.nextInt();
			product.isertDataProduct(Pname, Pdescription, price, quantity);
			System.out.println(i + "Product added Successfully..");
		}

	}

	public void admin_data() throws Throwable {

		ConnectionTest con = new ConnectionTest();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Admin Login id = ");
		String loginid = sc.next();
		System.out.println("Enter Admin password = ");
		String password = sc.next();
		try {
			Connection connection = con.getConnectionDetails();
			String relog = "select * from admin";
			Statement st = connection.createStatement();
			ResultSet logdata = st.executeQuery(relog);
			int count = 0;
			while (logdata.next()) {
				String logdb = logdata.getString(4);
				String pass = logdata.getString(5);

				if (loginid.equals(logdb) && (password.equals(pass))) {
					count++;
					System.out.println("welcome " + logdata.getString(2) + " " + logdata.getString(3));
					ProductPage p = new ProductPage();
					p.insertProduct();
				}
			}
			if (count == 0) {
				System.err.println("Invalid Login id OR Password....!..Retry");
				InvalidUseridOrPassword ivp = new InvalidUseridOrPassword("Invalid Login id OR Password....!");
				throw ivp;
			}

		} catch (Throwable e) {
			System.out.println(e);
			ProductPage u = new ProductPage();
			u.admin_data();
		}
	}
}