package com.example.demo;

public class Ride {

	
	private String source;
	private String destination;
	private dobule price = 0;
	private String driverName;
	private boolean accepted = false;
	private boolean completed;

	public void setPrice(int price) {
		this.price = price;
	}

	public Ride(String source, String destination) {
		this.source = source;
		this.destination = destination;

	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(double price, String driverName) {
		this.price = price;
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
		ApplicationHandler.getData().unNotifyDrivers(this);
	}

}
