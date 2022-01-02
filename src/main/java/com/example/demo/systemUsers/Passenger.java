package com.example.demo.systemUsers;
import com.example.demo.ApplicationHandler;
import com.example.demo.Rate;
import com.example.demo.Ride;



public class Passenger extends User {

	private Ride ride = null;
	private boolean firstRideDiscount = true;

	public Passenger(String username, String mobileNumber, String email, String password) {
		super(username, mobileNumber, email, password);
		
	}

	public void requestAride(String source, String destination,int maxNumOfPassengers) {
		Ride ride = new Ride(source, destination,maxNumOfPassengers);
		this.ride = ride;

		ApplicationHandler.getData().notifyAllDrivers(ride);
        ApplicationHandler.getData().addRide(ride , this);
		
	}

	public void rateDriver(Rate rating) {
	    
		ApplicationHandler.getData().addRating(rating);
        
	}
    
	public void removeRide(){
          this.ride = null;
	}
	public Ride getRide() {
		return ride;
	}
	public boolean isFirstRideDiscountAvailable() {
		return firstRideDiscount;
	}

	public void didFirstRide() {
		firstRideDiscount = false;
	}

}