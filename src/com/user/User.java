package com.user;

import java.util.Scanner;

import com.admin.*;

public class User {
	public void executeUser() throws Throwable {
		try {
			Userlogin u = new Userlogin();
			Scanner sc = new Scanner(System.in);
			System.out.println("press 0 log in for already Registered User");
			System.out.println("press 1 for New Registration");

			String no = sc.next();
			switch (no) {
			case ("1"): {
				u.touserLogin();
				break;
			}
			case ("0"): {
				u.logincheck();
				break;
			}
			default: {
				System.err.println("invalid selection");
				Inavalid_Selection ivs = new Inavalid_Selection("invalid Selection.......!");
				throw ivs;
			}

			}
		} catch (Throwable e) {
			System.out.println(e);
			User u = new User();
			u.executeUser();
		}

	}

}
