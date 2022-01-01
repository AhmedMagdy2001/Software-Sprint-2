package com.example.demo.systemUsers;

import com.example.demo.Database.Database;

import org.springframework.beans.factory.annotation.Autowired;

public class Admin extends User {


	
	public Admin(String username, String mobileNumber, String email, String password) {
		super(username, mobileNumber, email, password);
	}

	public String verifydriverRegistration(String username) {
		return data.verifydriverRegistration(username);
	}

	public String suspend(String username){
		return data.suspend(username);
	}

	public String unsuspend(String username) {
		return data.unsuspend(username);
	}

}