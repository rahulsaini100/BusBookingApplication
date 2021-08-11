package com.timesinternet.busbooking.controllers;

import com.timesinternet.busbooking.services.*;

import com.timesinternet.busbooking.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//<<<<<<< HEAD
import java.util.*;
import java.sql.Date;
//=======
import java.sql.Date;
import java.util.List;
//>>>>>>> branch 'main' of https://github.com/vikaxxxx/BusBookingApplication.git

@RestController
public class Controller {

	private final ServiceLayer serviceLayer;

	@Autowired
	public Controller(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}

	@PostMapping(value = "/search")
	public List<AvailableBus> AvailableBuses(@RequestParam String fromCityName, @RequestParam String toCityName,
			@RequestParam Date journeyDate, @RequestParam long numberOfPassenger) {

		return serviceLayer.availableBuses(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}
    
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
    	public List<GenerateTicket> myBookingFn(@RequestParam long userId){
    	
    	return serviceLayer.showBooking(userId);
    	
    }
	@PostMapping(value = "/generateticket")
	public GenerateTicket generateTicket(@RequestParam long userId, @RequestParam String busId,
			@RequestParam String routeId, @RequestParam long numberOfSeats, @RequestParam Date journeyDate) {
		Ticket ticket = new Ticket(userId, busId, routeId, numberOfSeats, journeyDate);
		return serviceLayer.ticketGeneration(ticket);
	}
//>>>>>>> branch 'main' of https://github.com/vikaxxxx/BusBookingApplication.git
}
