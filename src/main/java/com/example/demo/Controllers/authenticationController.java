package com.example.demo.Controllers;


import com.example.demo.ApplicationHandler;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authentication")

public class authenticationController {


	@PostMapping("/registerPassenger")
	public String RegisterPassenger(@RequestBody Passenger passenger) {
        
	       return ApplicationHandler.getData().addPassenger(passenger);

	}
	@PostMapping("/registerDriver")
	public String RegisterDriver(@RequestBody Driver driver) {
        
	       return ApplicationHandler.getData().addDriver(driver);

	}

	 @PostMapping("/login")
     public String login(@RequestBody LoginInput credintials){
		 return ApplicationHandler.getData().login(credintials);
	 }
	

}
