package com.example.demo.Database;
import java.util.ArrayList;
import com.example.demo.FavouriteArea;
import com.example.demo.Rate;
import com.example.demo.Ride;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;


import org.springframework.stereotype.Component;

@Component
public class ArrayStorage implements Database {

	// private ArrayList<Driver> PendingRegistrations = new ArrayList<Driver>();
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	private ArrayList<Rate> Ratings = new ArrayList<Rate>();
	private ArrayList<Ride> Rides = new ArrayList<Ride>();
	private ArrayList<FavouriteArea> FavAreas = new ArrayList<FavouriteArea>();

	public void addRating(Rate rating) {
		this.Ratings.add(rating);
	}

	public void addRide(Ride ride) {
		this.Rides.add(ride);
	}

	public String addFavArea(FavouriteArea favArea) {
		this.FavAreas.add(favArea);

		return "added " +this.FavAreas.get(0)+" to your favourite areas";
	}
	/*
	 * public void addNewDriver(Driver driver) {
	 * this.PendingRegistrations.add(driver);
	 * }
	 * 
	 * public ArrayList<Driver> getPendingRegistrations() {
	 * return PendingRegistrations;
	 * }
	 */

	public ArrayList<Rate> getRatings() {
		return Ratings;
	}

	public ArrayList<Ride> getRides() {
		return Rides;
	}

	public ArrayList<FavouriteArea> getFavAreas() {
		return FavAreas;
	}

	public String login(LoginInput credintials) {

		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(credintials.username)
					&& passengers.get(i).getPassword().equals(credintials.password)) {
                
						if(passengers.get(i).getSuspend()){
							return "you have been suspended";
						}
						else{
							return "You have been logged in";
						}
				
			}
		}
		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(credintials.username)
					&& drivers.get(i).getPassword().equals(credintials.password)) {
				if (drivers.get(i).isVerify()) {
					if(drivers.get(i).getSuspend()){
						return "you have been suspended";
					}
					else{
						return "You have been logged in";
					}
				} else {
					return  "You haven't been verified yet";
				}

			}
		}

		return null;
	}

	public Passenger getPassengerByUsername(String username) {
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(username)) {

				return passengers.get(i);
			}
		}

		return null;
	}

	public Driver getDriverByUsername(String username) {
		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(username)) {
				return drivers.get(i);
			}
		}

		return null;
	}

	public String verifydriverRegistration(String username) {

		for (int i = 0; i < this.drivers.size(); i++) {

			if (this.drivers.get(i).getUsername().equals(username)) {

				this.drivers.get(i).setVerify(true);

				return "driver verified";
			}
		}
		return null;
	}

	public void ListdriverRegistrations() {

		for (int i = 0; i < this.drivers.size(); i++) {
			if (!this.drivers.get(i).isVerify()) {
				System.out.println("|' Username: " + this.drivers.get(i).getUsername());
				System.out.println("|  Nationalid:" + this.drivers.get(i).getNationalId());
				System.out.println("|' Drivinglicense: " + this.drivers.get(i).getDrivingLicense() + "\n");
			}

		}

	}

	public void listDrivers() {
		for (int i = 0; i < this.drivers.size(); i++) {
			if (drivers.get(i) instanceof Driver) {
				System.out.println("Driver's name: " + drivers.get(i).getUsername());
			}
		}
	}

	public void listAllRides() {
		for (int i = 0; i < passengers.size(); i++) {
			Passenger passenger = passengers.get(i);
			if (passenger.getRide() != null) {
				System.out.println("Passenger:" + passenger.getUsername() + " has requested a ride from "
						+ passenger.getRide().getSource() + " to " + passenger.getRide().getDestination());
			}

		}
	}

	public void suggestRidePrice(String source, int price, String driverName) {

		for (int i = 0; i < passengers.size(); i++) {

			Passenger passenger = passengers.get(i);
			if (passenger.getRide().getSource().equals(source)) {

				passenger.getRide().setPrice(price, driverName);
			}

		}

	}

	public void listUsersRatings(Driver driver) {

		for (int i = 0; i < this.Ratings.size(); i++) {

			if (this.Ratings.get(i).getDriverName().equals(driver.getUsername())) {
				System.out.println("Passenger: " + this.Ratings.get(i).getPassengerName() + "|| Rate: "
						+ this.Ratings.get(i).getRate());

			}

		}

	}

	public void checkDriverAvgRating(String driverName) {

		int average = 0;

		for (int i = 0; i < this.Ratings.size(); i++) {
			if (this.Ratings.get(i).getDriverName().equals(driverName)) {
				average += this.Ratings.get(i).getRate();
				average = average / this.Ratings.size();
			}

		}

		System.out.println(driverName + " got : " + average);
	}

	public String addPassenger(Passenger passenger) {
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(passenger.getUsername())
					&& passengers.get(i).getPassword().equals(passenger.getPassword())) {
                
               return "This passenger already Exists !";
			}
		}
		this.passengers.add(passenger);
		return "registeration completed";
	}

	public String addDriver(Driver driver) {
		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(driver.getUsername())
					&& drivers.get(i).getPassword().equals(driver.getPassword())) {

				return "This driver already Exists !";
		}
	}
		this.drivers.add(driver);
		return "registeration completed";
	}

	public String suspend(String username) {
		for (int i = 0; i < this.drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(username)) {
				drivers.get(i).setSuspend(true);

				return drivers.get(i).getUsername()+" has been suspended";
			}
		}
		for (int i = 0; i < this.passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(username)) {
				passengers.get(i).setSuspend(true);

				return passengers.get(i).getUsername()+" has been suspended";
			}
		}
		return null;
	}

	public String unsuspend(String username) {
		for (int i = 0; i < this.drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(username)) {
				drivers.get(i).setSuspend(false);
				
				return drivers.get(i).getUsername()+" has been unsuspended";
			}
		}
		for (int i = 0; i < this.passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(username)) {
				passengers.get(i).setSuspend(false);

				return passengers.get(i).getUsername()+" has been unsuspended";
			}
		}
		return null;
	}

	public void listSuspendedUsers() {
		System.out.println("suspended users \n");

		for (int i = 0; i < this.passengers.size(); i++) {
			if (this.passengers.get(i).getSuspend()) {
				System.out.println((i + 1) + "- " + this.passengers.get(i).getUsername());
			}

		}
		for (int i = 0; i < this.drivers.size(); i++) {
			if (this.drivers.get(i).getSuspend()) {
				System.out.println((i + 1) + "- " + this.drivers.get(i).getUsername());
			}

		}
	}

}