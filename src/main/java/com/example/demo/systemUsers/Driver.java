package com.example.demo.systemUsers;

import com.example.demo.ApplicationHandler;
import com.example.demo.FavouriteArea;
import com.example.demo.inputClasses.driverInput;

public class Driver extends User {

	private String drivingLicense = "";
	private String NationalId = "";
	private boolean verified = false;

	public Driver(String username, String mobileNumber, String email, String password,
			String drivingLicense, String nationalId) {
		super(username, mobileNumber, email, password);
		this.drivingLicense = drivingLicense;
		this.NationalId = nationalId;

	}

	public String addFavArea(String source) {
		FavouriteArea favArea = new FavouriteArea(source, this.getUsername());
		return ApplicationHandler.getData().addFavArea(favArea);

	}

	public void listAllRides(){
          ApplicationHandler.getData().listAllRides();
	}

	public void suggestPrice(String source, int price) {

		 ApplicationHandler.getData().suggestRidePrice(source, price,this.getUsername());
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public String getNationalId() {
		return NationalId;
	}

	public boolean isVerify() {
		return verified;
	}

	public void setVerify(boolean verify) {
		this.verified = verify;
	}
}