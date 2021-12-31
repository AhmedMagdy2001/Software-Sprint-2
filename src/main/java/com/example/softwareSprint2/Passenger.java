package com.example.demo;
public class Passenger extends User {
	private Ride ride = null;
	

	public Passenger(String username, String mobileNumber, String email, String password/*, Database database*/) {

		super(username, mobileNumber, email, password/*, database*/);

	}

	void requestAride(String source, String destination) {

		Ride ride = new Ride(source, destination);
		this.ride = ride;

	}

	void rateDriver(int rate, String driverName, Passenger passenger) {

		Rate rating = new Rate(passenger.getUsername(), driverName, rate);

		getDatabase().addRating(rating);

	}

	public Ride getRide() {
		return ride;
	}

}