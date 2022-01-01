package com.example.demo;
public class Ride {

	private String source;
	private String destination;
	private int price = 0;
	private String driverName;


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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price, String driverName) {
		this.price = price;
		this.driverName = driverName;
	}


	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}

