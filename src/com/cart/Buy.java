package com.cart;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;
    import com.product.*;
    import com.admin.*;
	public class Buy {
		public void toBuy(int amount) throws Throwable {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter " + amount + " Amount to PLACE ORDER");
				String amt = sc.next();
				String Samount = Integer.toString(amount);
				if (amt.equals(Samount)) {
					System.out.println("Your Order is PLACED.  Your order Delivered in 7 working Day's.");
					System.out.println("THANK YOU...");
					ConnectionTest con = new ConnectionTest();

					Connection connection = con.getConnectionDetails();
					Statement stmt = connection.createStatement();
					String savehistory="select * from cart";
					ResultSet save = stmt.executeQuery(savehistory);
					while(save.next()) {
						
					}
		
					String truncate = "truncate table cart";
					stmt.execute(truncate);
					Thread.sleep(3000);
					ProductDataUser pd = new ProductDataUser();
					pd.productData();

				} else {
					System.err.println("Incorrect input.... ");
					Inavalid_Selection ivs=new Inavalid_Selection("Invalid Selection...! Try again");
					Buy b=new Buy();
					b.toBuy(amount);
				}

			} catch (SQLException e) {
			
				e.printStackTrace();
			}catch(Throwable e) {
				
				Buy buy = new Buy();
				buy.toBuy(amount);
			}
		}
	}

