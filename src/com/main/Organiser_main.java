package com.main;

import java.util.Scanner;
import com.admin.*;
import com.user.User;

public class Organiser_main {
	public void m1() throws Throwable {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 0 for User");
			System.out.println("Enter 1 for admin");
			String input = sc.next();
			switch (input) {
			case ("0"): {
				User u = new User();
				u.executeUser();
				break;
			}
			case ("1"): {
				AdminLogin admin = new AdminLogin();
				admin.adminlogin();
				break;
			}
			default: {
				System.err.println("Invalid Selection...! Try again");
				Inavalid_Selection ivs = new Inavalid_Selection("Invalid Selection...! Try again");
				throw ivs;
			}
			}
		} catch (Throwable e) {
			System.out.println(e);
			Organiser_main om = new Organiser_main();
			om.m1();
		}

	}
}
