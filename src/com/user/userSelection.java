package com.user;

import java.util.Scanner;

import com.admin.*;
import com.cart.Cart;
import com.product.*;

public class userSelection {
	public void selectInput() throws Throwable {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 1 to add Cart by particular itom  ");
			System.out.println("Enter 2 show itom in Ascending order by Price");
			System.out.println("Enter 4 for show my cart ");
			System.out.println("Enter 0 for Home page ");
			String Selection = sc.next();
			switch (Selection) {
			case ("1"): {
				Action_Product act = new Action_Product();
				act.addcart();
			}
			case ("0"): {
				User u = new User();
				u.executeUser();
			}
			case ("2"): {
				Ascending_product ap = new Ascending_product();
				ap.getAscending();
			}
			case ("4"): {
				Cart c = new Cart();
				c.showCart();
			}
			default: {
				System.err.println("Invalid Selection...! Try again");
				Inavalid_Selection ivs = new Inavalid_Selection("Invalid Selection...! Try again");
				throw ivs;
			}
			}

		} catch (Throwable e) {
			System.out.println(e);
			userSelection us = new userSelection();
			us.selectInput();
		}

	}
}
