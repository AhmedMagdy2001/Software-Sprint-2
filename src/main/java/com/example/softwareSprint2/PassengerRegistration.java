package com.example.demo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registerPassenger")

public class PassengerRegistration {
	Database data;

	public PassengerRegistration(){

	}

	public PassengerRegistration(Database data) {
		this.data = data;
	}

	@PostMapping("/register")
	public void Register(@RequestBody User user) {

		//Passenger passenger = (Passenger) user;
		data.addUser(user);

	}
}
