package com.example.demo;
import java.util.ArrayList;

public interface Database {
	
	public void addRide(Ride ride);
	
	public void addRating(Rate rating);

	public void addFavArea(FavouriteArea favArea);
	
	public void addNewDriver(Driver driver);
	
	public void addUser(User user);
	
	public ArrayList<Driver> getPendingRegistrations();
	
	public ArrayList<User> getUsers();

	public ArrayList<Rate> getRatings();

	public ArrayList<Ride> getRides();

	public ArrayList<FavouriteArea> getFavAreas();
	
	public void ListdriverRegistrations();
	
	public void verifydriverRegistration(String username);

	public void listDrivers();

	public User SearchDriver(String username);

	public void listAllRides();

	public void suggestRidePrice(String source, int price, String driverName);

	void listUsersRatings(Driver driver);

	void checkDriverAvgRating(String driverName);


	public void listSuspendedUsers();
	
}
