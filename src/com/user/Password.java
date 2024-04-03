package com.user;

import java.util.Scanner;

public class Password {
	public String checkPassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter to set User password = ");
		System.out.println("Password should be minimum 6 charactor ");
		System.out.println("and it contan minimum one Capital letter,one small letter,one Numbers,one(#,$,%,@)");
		String s = sc.next();
		String password = "";
		int ch;
		int capital = 0;
		int small = 0;
		int number = 0;
		int special = 0;
		int space = 0;
		if (s.length() >= 6) {
			for (int i = 0; i < s.length(); i++) {

				ch = s.charAt(i);
				if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
					capital++;
				} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
					small++;
				}

				else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					number++;
				} else if ((ch >= 35) && (ch <= 38) || (ch == 64)) {
					special++;
				} else if (ch == 32) {
					space++;
				}
			}
			if (capital != 0 && small != 0 && number != 0 && special != 0 && space <= 0) {
				password = password + s;

			} else {
				System.err.println("Password is not per requirement");
				Password p = new Password();
				p.checkPassword();
			}

		} else {
			System.err.println("password have minimum 6 charactor");
			Password p = new Password();
			p.checkPassword();
		}
		return s;

	}
}
