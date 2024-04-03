package com.admin;

public class InvalidUseridOrPassword extends RuntimeException{
	public InvalidUseridOrPassword(String msg) {
		super(msg);
	}

}
