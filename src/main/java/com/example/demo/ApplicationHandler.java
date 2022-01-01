package com.example.demo;

import java.util.ArrayList;

import com.example.demo.Database.ArrayStorage;
import com.example.demo.Database.Database;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;

public class ApplicationHandler {
    	
	private static ApplicationHandler application;

	private static Database database;

	private ApplicationHandler(){}

	public static ApplicationHandler getData(){

		if(application == null){
		    application = new ApplicationHandler();
            database = new ArrayStorage();
		}
		return application;
	}
    public void setDatabase(Database database) {
        ApplicationHandler.database = database;
    }
    public void addRide(Ride ride){
        database.addRide(ride);
    };

	public void addRating(Rate rating){
        database.addRating(rating);
    }

	public String addFavArea(FavouriteArea favArea){
        return database.addFavArea(favArea);
    }

	public String addPassenger(Passenger passenger){
     return  database.addPassenger(passenger);
    }

	public String addDriver(Driver driver){
        return database.addDriver(driver);
    }

	public String login(LoginInput credintials){
        return database.login(credintials);
    }

	public Passenger getPassengerByUsername(String username){
        return database.getPassengerByUsername(username);
    }

	public Driver getDriverByUsername(String username){
        return database.getDriverByUsername(username);
    }

	public ArrayList<Rate> getRatings(){
        return database.getRatings();
    }

	public ArrayList<Ride> getRides(){
        return database.getRides();
    }

	public ArrayList<FavouriteArea> getFavAreas(){
        return database.getFavAreas();
    }

	public void ListdriverRegistrations(){
         database.ListdriverRegistrations();
    }

	public String verifydriverRegistration(String username){
        return database.verifydriverRegistration(username);
    }

	public void listDrivers(){
         database.listDrivers();
    }

	public void listAllRides(){
        database.listAllRides();
    }

	public void suggestRidePrice(String source, int price, String driverName){
        database.suggestRidePrice(source, price, driverName);
    }

	void listUsersRatings(Driver driver){
        database.listUsersRatings(driver);
    }

	void checkDriverAvgRating(String driverName){
        database.checkDriverAvgRating(driverName);
    }

	public String suspend(String username){
        return database.suspend(username);
    }

	public String unsuspend(String username){
        return database.unsuspend(username);
    }

	public void listSuspendedUsers(){
        database.listSuspendedUsers();
    }
}
