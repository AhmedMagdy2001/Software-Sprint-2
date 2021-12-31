package com.example.demo;
import java.util.ArrayList;

public class ArrayStorage implements Database {

	private ArrayList<Driver> PendingRegistrations = new ArrayList<Driver>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Rate> Ratings = new ArrayList<Rate>(); // driver
	private ArrayList<Ride> Rides = new ArrayList<Ride>(); // driver
	private ArrayList<FavouriteArea> FavAreas = new ArrayList<FavouriteArea>(); // driver

	public void addRating(Rate rating) {
		this.Ratings.add(rating);
	}

	public void addRide(Ride ride) {
		this.Rides.add(ride);
	}

	public void addFavArea(FavouriteArea favArea) {
		this.FavAreas.add(favArea);
	}

	public void addNewDriver(Driver driver) {
		this.PendingRegistrations.add(driver);
	}

	public ArrayList<Driver> getPendingRegistrations() {
		return PendingRegistrations;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Rate> getRatings() {
		return Ratings;
	}

	public ArrayList<Ride> getRides() {
		return Rides;
	}

	public ArrayList<FavouriteArea> getFavAreas() {
		return FavAreas;
	}

	public void verifydriverRegistration(String username) {

		for (int i = 0; i < this.PendingRegistrations.size(); i++) {

			if (this.PendingRegistrations.get(i).getUsername().equals(username)) {

				this.PendingRegistrations.get(i).setVerify(true);

				User user = (User) this.PendingRegistrations.get(i);

				addUser(user);

				this.PendingRegistrations.remove(this.PendingRegistrations.get(i));
				break;
			}
		}
	}

	public void ListdriverRegistrations() {

		for (int i = 0; i < this.PendingRegistrations.size(); i++) {

			System.out.println("|' Username: " + this.PendingRegistrations.get(i).getUsername());
			System.out.println("|  Nationalid:" + this.PendingRegistrations.get(i).getNationalId());
			System.out.println("|' Drivinglicense: " + this.PendingRegistrations.get(i).getDrivingLicense() + "\n");
		}

	}

	public void listDrivers() {
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i) instanceof Driver) {
				System.out.println("Driver's name: " + users.get(i).getUsername());
			}
		}
	}

	public User SearchDriver(String username) {
		User user = null;
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i) instanceof Driver && users.get(i).getUsername().equals(username)) {
				user = users.get(i);
			}
		}
		return user;
	}

	public void listAllRides() {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) instanceof Passenger) {
				Passenger passenger = (Passenger) users.get(i);
				
				if (passenger.getRide() != null) {
					System.out.println("Passenger:" + passenger.getUsername() + " has requested a ride from "
							+ passenger.getRide().getSource() + " to " + passenger.getRide().getDestination());
				}

			}
		}
	}

	public void suggestRidePrice(String source, int price, String driverName) {

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) instanceof Passenger) {
				Passenger passenger = (Passenger) users.get(i);

				if (passenger.getRide().getSource().equals(source)) {

					passenger.getRide().setPrice(price, driverName);
				}
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

	public void addUser(User user) {
		this.users.add(user);
	}

	public void listSuspendedUsers() {
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getSuspend()) {
				System.out.println("suspended users \n" + (i + 1) + "- " + this.users.get(i).getUsername());
			}

		}
	}

}
