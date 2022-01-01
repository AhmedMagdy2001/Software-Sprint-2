package com.example.demo.Controllers;
import com.example.demo.Ride;
import com.example.demo.Database.Database;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.inputClasses.RideInput;
import com.example.demo.systemUsers.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/passenger")

public class passengerController {

@Autowired
Database data;

  
     @PostMapping("/requestRide")
     public Ride requestRide(@RequestBody RideInput rideCredintials) {

        Passenger passenger = data.getPassengerByUsername(rideCredintials.passengerUsername);
        passenger.requestAride(rideCredintials.source, rideCredintials.destination);

        return passenger.getRide();
	  }
    

      @PostMapping("/check")
     public Ride checkRide(@RequestBody LoginInput credintials){

        Passenger passenger = data.getPassengerByUsername(credintials.username);
        
        return passenger.getRide();
     }
	

                                                                     

}
