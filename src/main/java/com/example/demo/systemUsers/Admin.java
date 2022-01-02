package com.example.demo.systemUsers;

import com.example.demo.ApplicationHandler;

public class Admin extends User {


	
	public Admin(String username, String mobileNumber, String email, String password) {
		super(username, mobileNumber, email, password);
	}

	public String verifydriverRegistration(String username) {
		 return ApplicationHandler.getData().verifydriverRegistration(username);
	}

	public String suspend(String username){
		return ApplicationHandler.getData().suspend(username);
	}

	public String unsuspend(String username) {
		return ApplicationHandler.getData().unsuspend(username);
	}

	public void addDiscount(String destination ){
		ApplicationHandler.getData().addDiscountedDestination(destination);
	}
}