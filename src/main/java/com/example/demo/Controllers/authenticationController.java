package com.example.demo.Controllers;


import com.example.demo.Database.Database;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authentication")

public class authenticationController {

@Autowired
Database data;

  
	@PostMapping("/registerPassenger")
	public String RegisterPassenger(@RequestBody Passenger passenger) {
        
	       return data.addPassenger(passenger);

	}
	@PostMapping("/registerDriver")
	public String RegisterDriver(@RequestBody Driver driver) {
        
	       return data.addDriver(driver);

	}

	 @PostMapping("/login")
     public String login(@RequestBody LoginInput credintials){
		 return data.login(credintials);
	 }
	

}
