package com.example.demo.Controllers;

import com.example.demo.ApplicationHandler;
import com.example.demo.DemoApplication;
import com.example.demo.Rate;
import com.example.demo.Ride;
import com.example.demo.Database.Database;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.inputClasses.RideInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;

import org.springframework.web.bind.annotation.GetMapping;
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

   @GetMapping("/checkRideOffer")
   public Ride checkRideOffer(@RequestBody RideInput credintials) {

      Passenger passenger = ApplicationHandler.getData().getPassengerByUsername(credintials.passengerUsername);

      return passenger.getRide();
   }

   @PostMapping("/acceptRideOffer")
   public String acceptRideOffer(@RequestBody RideInput credintials) {

      Passenger passenger = ApplicationHandler.getData().getPassengerByUsername(credintials.passengerUsername);
      String driverName = passenger.getRide().getDriverName();
      passenger.getRide().setAccepted(true);

      ApplicationHandler.getData().unNotifyDrivers(passenger.getRide()); //if ride is accepted we remove it from the requested rides in other drivers

      Driver driver = ApplicationHandler.getData().getDriverByUsername(driverName);
      driver.setAvailable(false);

      return "Ride Accepted";
   }

   @PostMapping("/rate")
   public String rateDriver(@RequestBody RideInput credintials) {

      Passenger passenger = ApplicationHandler.getData().getPassengerByUsername(credintials.passengerUsername);
      Rate rate = new Rate(passenger.getUsername(), passenger.getRide().getDriverName(), credintials.rate);
     
      if(passenger.getRide() == null){
         return "you didnt request a ride yet !";
      }
      else{
         passenger.rateDriver(rate);
         passenger.removeRide();
      }
     return null;
   }

   @GetMapping("/checkAverageRating")
   public String checkAverageRating(@RequestBody RideInput credintials) {
      return ApplicationHandler.getData().checkDriverAvgRating(credintials.driverUsername);

   }

}
