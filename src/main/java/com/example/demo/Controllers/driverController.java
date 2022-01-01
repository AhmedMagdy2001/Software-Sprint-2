package com.example.demo.Controllers;
import java.util.ArrayList;

import com.example.demo.FavouriteArea;
import com.example.demo.Ride;
import com.example.demo.Database.Database;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.inputClasses.RideInput;
import com.example.demo.inputClasses.driverInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/driver")

public class driverController {

@Autowired
Database data;

  
     @PostMapping("/addFavouriteArea")
     public String addFavouriteArea(@RequestBody driverInput input) {
        Driver driver = data.getDriverByUsername(input.username);

        return driver.addFavArea(input.source);
	 }
    

     @PostMapping("/check")
     public Ride checkRide(@RequestBody LoginInput credintials){

        Passenger passenger = data.getPassengerByUsername(credintials.username);
        
        return passenger.getRide();
     }
	

                                                                     

}
