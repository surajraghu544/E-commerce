package com.admin;
import java.util.Scanner;

import com.main.Organiser_main;
import com.product.*;
import com.user.*;
public class Admin_Control {
public void tocontroladmin() throws Throwable {

	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to show  Available Product Stock  ");
		System.out.println("Enter 2 show itom in Ascending order by Quantity");
		System.out.println("Enter 4 Display the entire registered user list");
		System.out.println("Enter 5 for Add Product in Product Table");
		System.out.println("Enter 0 for log out");
		String Selection = sc.next();
		switch (Selection) {

		case ("1"): {
			AdminProductTable u = new AdminProductTable();
			u.productData();
			break;
		}
		case ("3"): {
			Ascending_product ap = new Ascending_product();
			ap.getAscending();
			break;
		}
		case ("4"): {
			All_User_Data c = new All_User_Data();
			c.getUserData();
			break;
		}
		case ("2"): {
			AscProductQTy asp = new AscProductQTy();
			asp.getAscending();
			break;
		}
		case ("0"): {
			Organiser_main m = new Organiser_main();
			m.m1();
			break;}
		case ("5"): {
			ProductPage p= new ProductPage();
			p.insertProduct();}
		default: {
			System.err.println("invalid selection");
			Inavalid_Selection ivs = new Inavalid_Selection("invalid Selection.......!");
			throw ivs;

		}
		}
	} catch (Throwable t) {
		System.out.println(t);
		Admin_Control AC = new Admin_Control();
		AC.tocontroladmin();
	}
}
}