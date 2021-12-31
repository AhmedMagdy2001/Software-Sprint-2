package com.example.demo;

public class Driver extends User {

	private String drivingLicense = "";
	private String NationalId = "";
	private boolean verified = false;
    
	

	public Driver(String username, String mobileNumber, String email, String password, String drivingLicense,
			String nationalId, Database database) {

		super(username, mobileNumber, email, password/*database*/);
		this.drivingLicense = drivingLicense;
		NationalId = nationalId;

	}
	
	public void addFavArea(String source) {
		FavouriteArea favArea = new FavouriteArea(source, this.getUsername());
		getDatabase().addFavArea(favArea);
	}
	public void suggestPrice(String source , int price) {
	
		getDatabase().suggestRidePrice(source, price, this.getUsername());
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