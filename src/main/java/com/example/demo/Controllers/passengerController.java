package com.example.demo.Controllers;
import com.example.demo.ApplicationHandler;
import com.example.demo.DemoApplication;
import com.example.demo.Ride;
import com.example.demo.Database.Database;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.inputClasses.RideInput;
import com.example.demo.systemUsers.Passenger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/passenger")

public class passengerController {




  
     @PostMapping("/requestRide")
     public Ride requestRide(@RequestBody RideInput rideCredintials) {

        Passenger passenger = ApplicationHandler.getData().getPassengerByUsername(rideCredintials.passengerUsername);
        passenger.requestAride(rideCredintials.source, rideCredintials.destination);

        return passenger.getRide();
	  }
    

      @PostMapping("/checkRideOffer")
     public Ride checkRideOffer(@RequestBody RideInput credintials){

        Passenger passenger = ApplicationHandler.getData().getPassengerByUsername(credintials.passengerUsername);
        
        return passenger.getRide();
     }
	

                                                                     

}
