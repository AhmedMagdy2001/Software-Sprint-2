package com.example.demo.systemUsers;

import java.util.ArrayList;

import com.example.demo.ApplicationHandler;
import com.example.demo.FavouriteArea;
import com.example.demo.Ride;
import com.example.demo.inputClasses.driverInput;

public class Driver extends User {

	public ArrayList<Ride> requestedRides = new ArrayList<Ride>();


	private String drivingLicense = "";
	private String NationalId = "";
	private boolean verified = false;
	private boolean available = true;
    private Ride ride = null;
	
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

	public void listAllRides() {
		ApplicationHandler.getData().listAllRides();
	}

	public String suggestPrice(String source , String passengerName, int price) {

		return ApplicationHandler.getData().suggestRidePrice(source, price, this.getUsername(), passengerName);
	}
	public void listRatings() {
		ApplicationHandler.getData().listUsersRatings(this);
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
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}