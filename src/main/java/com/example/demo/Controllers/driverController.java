package com.example.demo.Controllers;
import java.util.ArrayList;

import com.example.demo.ApplicationHandler;
import com.example.demo.FavouriteArea;
import com.example.demo.Ride;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.inputClasses.driverInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/driver")

public class driverController {
        
   

   @PostMapping("/addFavouriteArea")
     public String addFavouriteArea(@RequestBody driverInput input) {
        Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);

        return driver.addFavArea(input.source);
	 }

    @PostMapping("/suggestPrice")
    public String suggestPrice(@RequestBody driverInput input) {
       Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);
      return driver.suggestPrice(input.source,input.passengerUsername,input.price);

   }
   @PostMapping("/completeRide")
    public void completeRide(@RequestBody driverInput input) {
       Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);
       driver.setAvailable(true);
       
   }

   @GetMapping("/listRatings")
    public void listRatings(@RequestBody driverInput input) {
       Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);
       driver.listRatings();
       
   }
    
    
   @GetMapping("/listRides")
     public void getRides(@RequestBody driverInput input){
         Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);
         driver.listAllRides();
     }
	
     
                                                                     

}
