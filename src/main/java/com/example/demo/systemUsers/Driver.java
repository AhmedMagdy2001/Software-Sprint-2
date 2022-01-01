package com.example.demo.systemUsers;
import com.example.demo.FavouriteArea;
import com.example.demo.Database.Database;

import org.springframework.beans.factory.annotation.Autowired;

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

		if(data != null){
            return "not null";
		}
		else{
            return "null";
		}
	}
	public void suggestPrice(String source , int price) {
	
		data.suggestRidePrice(source, price, this.getUsername());
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