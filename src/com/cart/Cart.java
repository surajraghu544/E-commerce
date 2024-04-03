package com.cart;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.admin.*;
import com.product.*;

import com.product.Action_Product;
import com.user.User;
public class Cart {
	public void showCart() throws Throwable {
		ConnectionTest ct=new ConnectionTest();
		try {
			Connection connection = ct.getConnectionDetails();
			Statement stmt = connection.createStatement();
			ResultSet cart = stmt.executeQuery("select * from cart");
			int TotalPrice=0;
			while(cart.next()) {
				System.out.println("Sr No =           "+cart.getInt(1));
				System.out.println();
				System.out.println("Poduct id =           "+cart.getInt(2));
				System.out.println();
				System.out.println("Product Name =        "+cart.getString(3));
				System.out.println();
				System.out.println("Product Description = "+cart.getString(4));
				System.out.println();
				System.out.println("Product Price =        "+cart.getInt(5));
				System.out.println();
				System.out.println("Product Quantity =     "+cart.getInt(6));
				System.out.println();
				System.out.println("*********************************************");
				TotalPrice=TotalPrice+cart.getInt(5);
			}
			System.out.println("Total Price of All cart Product = "+TotalPrice);
			Thread.sleep(3000);
			if (TotalPrice==0) {
				System.err.println("Your Cart is Empty");
				ProductDataUser u=new ProductDataUser();
				u.productData();
			} 
			else {
				
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter 0 for PLACED ORDER");
			System.out.println("Enter 1 to add Cart by particular product  ");
			System.out.println("Enter 2 for to Remove particular Product from cart ");
			System.out.println("Enter 3 show itom in Ascending order by Price");
			System.out.println("Enter 4 for Home page ");
			
			String Selection=sc.next();
			switch(Selection) {
			case("1"):{
				Action_Product act=new Action_Product();
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter id no which Product you want add cart or Buy=");
				int s=scan.nextInt();
				act.addcart();
			}
			case("4"):{
				User u=new User();
				u.executeUser();
				break;
			}
			case("3"):{
				Ascending_product ap=new Ascending_product();
				ap.getAscending();
				break;
			}
			case("2"):{
				RemoveProductCart ap=new RemoveProductCart();
				ap.showCart();
				break;}
			case("0"):{
				
				Buy b=new Buy();
				b.toBuy(TotalPrice);
				break;
			}
			default:{
				System.err.println("Invalid Selection...! Try again");
				Inavalid_Selection ivs=new Inavalid_Selection("Invalid Selection...! Try again");
	            throw ivs;
			}
			}
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println(e);
			Cart c=new Cart();
			c.showCart();
			
		}
	}

}

