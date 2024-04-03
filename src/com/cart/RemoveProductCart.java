package com.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.admin.ConnectionTest;

public class RemoveProductCart {

	public void showCart() throws Throwable {
		ConnectionTest ct=new ConnectionTest();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product id for which Product You want to Remove ");
		int input=sc.nextInt();
		try {
			Connection connection = ct.getConnectionDetails();
			String sql="select * from cart";
			String sq2="select * from product";
			Statement stmt = connection.createStatement();
			ResultSet rd = stmt.executeQuery(sql);
			int quantity=0;
			int pqty=0;
			while(rd.next()) {
				if(input==rd.getInt(2)) {
					quantity=quantity+rd.getInt(6);
				}}
				ResultSet rd1 = stmt.executeQuery(sq2);
				while(rd1.next()) {
					if(input==rd1.getInt(5)) {
					pqty=pqty+rd1.getInt(5)	;
				}
		}
			 PreparedStatement ps = connection.prepareStatement("delete from cart where product_id= ?");
		   ps.setInt(1, input);
		   ps.executeUpdate();
		   System.out.println("done");
		   PreparedStatement ps2 = connection.prepareStatement("update product set quantity=? where id= ?");
		   int qty=pqty+quantity;
      ps2.setInt(1, qty);
      ps2.setInt(2, input);
      ps2.executeUpdate();
      System.out.println("product table update");
      Cart c=new Cart();
      c.showCart();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		}
}