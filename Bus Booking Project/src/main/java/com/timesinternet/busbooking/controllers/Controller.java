package com.timesinternet.busbooking.controllers;
import com.timesinternet.busbooking.services.*;

import com.timesinternet.busbooking.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.sql.Date;

@RestController
public class Controller {

  private final ServiceLayer serviceLayer;

  @Autowired
  public Controller(ServiceLayer serviceLayer) {
    this.serviceLayer = serviceLayer;
  }


  @PostMapping(value = "/search")
    public List<abc> AvailableBuses(
          @RequestParam String fromCityName,
          @RequestParam String toCityName
          ){

      return serviceLayer.availableBuses(fromCityName,toCityName);

  }
    /////////////////////////////////////////////////////////////////////
    
    @PostMapping(value = "/saveuser")
    	public long updateUserAndTicketTable(
    			@RequestParam String userName,
    			@RequestParam String userPhoneNumber,
    			@RequestParam String userAddress
    			) {
    				Users u = new Users(userName, userPhoneNumber, userAddress);
    				return serviceLayer.addNewUser(u);    				
    }
    	
    ///////////////////////////////////////////////////////////////////
    
    @PostMapping(value = "/mybooking")
    	public List<Ticket> myBookingFn(@RequestParam long userId){
    	
    	return serviceLayer.showBooking(userId);
    	
    }
}
