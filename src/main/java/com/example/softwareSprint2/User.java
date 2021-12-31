package com.example.demo;





public class User {

	private String username = "";
	private String mobileNumber = "";
	private String email = "";
	private String Password = "";
	private boolean suspend = false;
	private Database database;

	
	public User(String username, String mobileNumber, String email, String password/*, Database database*/) {

		this.username = username;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.Password = password;
		/*this.database = database;*/
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public Database getDatabase() {
    	return database;
    }
	
	public void setSuspend(boolean suspended) {

		this.suspend = suspended;

	}

	public boolean getSuspend() {
		return suspend;
	}

}
