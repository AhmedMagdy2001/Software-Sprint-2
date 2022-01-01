package com.example.demo.systemUsers;

import com.example.demo.Rate;
import com.example.demo.Ride;
import com.example.demo.Database.Database;
import org.springframework.beans.factory.annotation.Autowired;




public class Passenger extends User {



	private Ride ride = null;
	
    
	public Passenger(String username, String mobileNumber, String email, String password) {
		super(username, mobileNumber, email, password);
		
	}

	public void requestAride(String source, String destination) {
        
		Ride ride = new Ride(source, destination);
		this.ride = ride;

	}

	void rateDriver(int rate, String driverName) {

		Rate rating = new Rate(this.getUsername(), driverName, rate);

		data.addRating(rating);

	}

	public Ride getRide() {
		return ride;
	}

}