package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.admin.ConnectionTest;
import com.admin.InvalidUseridOrPassword;
import com.product.*;

public class Userlogin {

	public void doLogin(String name, String Lname, String email, String mono, String address, String loginid,
			String password) throws Throwable {
		ConnectionTest con = new ConnectionTest();

		try {
			Connection connection = con.getConnectionDetails();
			PreparedStatement pps = connection.prepareStatement(
					"insert into userlogin(First_Name, Last_Name, Email, mobile_number, Address, loginid, password)values (?,?,?,?,?,?,?)");
			pps.setString(1, name);
			pps.setString(2, Lname);
			pps.setString(3, email);
			pps.setString(4, mono);
			pps.setString(5, address);
			pps.setString(6, loginid);
			pps.setString(7, password);
			pps.executeUpdate();
			System.out.println("Registration succssfull...!   thank You.");
			System.out.println("welcome ");
			ProductDataUser p = new ProductDataUser();
			p.productData();

			Userlogin ul = new Userlogin();
			ul.logincheck();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void touserLogin() throws Throwable {
		Userlogin user = new Userlogin();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your First name = ");
		String name = sc.next();
		System.out.println("Enter Your Last Name = ");
		String Lname = sc.next();
		System.out.println("Enter Your Email = ");
		String email = sc.next();
		System.out.println("Enter Your mobile Number = ");
		String mono = sc.next();

		System.out.println("Enter Your Address = ");
		String address = sc.next();
		System.out.println("Enter to set User Login id = ");
		String loginid = sc.next();
		Password p = new Password();
		String password1 = p.checkPassword();
		user.doLogin(name, Lname, email, mono, address, loginid, password1);
	}

	public void logincheck() throws Throwable {
		ConnectionTest con = new ConnectionTest();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Login id = ");
		String loginid = sc.next();
		System.out.println("Enter Your password = ");
		String password = sc.next();
		try {
			Connection connection = con.getConnectionDetails();
			String relog = "select * from userlogin";
			Statement st = connection.createStatement();
			ResultSet logdata = st.executeQuery(relog);
			int count = 0;
			while (logdata.next()) {
				String logdb = logdata.getString(4);
				String pass = logdata.getString(5);

				if (loginid.equals(logdb) && (password.equals(pass))) {
					count++;
					System.out.println("welcome " + logdata.getString(2) + " " + logdata.getString(3));
					ProductDataUser p = new ProductDataUser();
					p.productData();

				}
			}
			if (count == 0) {
				System.err.println("Invalid Login id OR Password....!..Retry");
				InvalidUseridOrPassword ivp = new InvalidUseridOrPassword("Invalid Login id OR Password....!");
				throw ivp;
			}

		} catch (Throwable e) {
			System.out.println(e);
			Scanner scan = new Scanner(System.in);
			System.out.println("You forgot Your password....?");
			System.out.println("Enter Y for get user id & password ");
			System.out.println("Enter N for Enter user id & password ");
			System.out.println("Enter 0 for new Registretion");
			String input = sc.next();
			switch (input) {
			case ("Y"): {
				Forgot_id_password i = new Forgot_id_password();
				i.getIDpassword();
				System.out.println("Enter correct mobile no or to do new Registration");
				break;
			}
			case ("0"): {
				Userlogin ul = new Userlogin();
				ul.touserLogin();
				break;
			}
			default: {
				Userlogin ul = new Userlogin();
				ul.logincheck();
				break;
			}
			}
		}
	}
}
