package com.timesinternet.busbooking.controllers;

import com.timesinternet.busbooking.services.*;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.sql.Date;

// This is a controller class which contains url for search API
@RestController
public class SearchController {

	private final ServiceLayer serviceLayer;


	@Autowired
	public SearchController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
		
	}
	
	//This takes inputs from user according to his/her needs 
	//The inputs are fromCityName(source city), toCityName(destination city) , journeyDate and number of passengers
	// There are some validations which must be followed in order to get proper output
	// Validations are From city and To city can not be same , number of passengers should not be greater than 50
	// It also call methods from service layer
	@PostMapping(value = "/search")
	public List<AvailableBus> AvailableBuses(@RequestParam String fromCityName, @RequestParam String toCityName,
			@RequestParam Date journeyDate, @RequestParam long numberOfPassenger) {
		
		//if source and destination city are same then it returns error 400 along with message
		if (fromCityName.equals(toCityName)) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From city and To city can not be same. Choose Again");
		}

		
		// If there is no such cities in database than it returns error 400 along with message
  
		Optional<City> cityOptional = serviceLayer.findByCityName(fromCityName);
		Optional<City> cityOptional1 = serviceLayer.findByCityName(toCityName);

		if (!cityOptional.isPresent() && !cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From And To city Not found in Our locations. Choose Any District from Haryana as locations!");

		}

		// If there is no such city in database as source city then it returns error 400 along with message

		if (!cityOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From city Not found in our locations. Choose Any District from Haryana as From city!");

		}

		// If there is no such city in database as destination city then it returns error 400 along with message
		if (!cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"To city Not found in our locations. Choose Any District from Haryana as To city!");

		}
		// to find maximum available seat in bus	
		String MaxAvailableSeats = serviceLayer.MaxAvailableSeats(fromCityName, toCityName, journeyDate);
		
		if (MaxAvailableSeats == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Oh Sorry. No Bus available on this route!");
		}

		// If number of passengers is greater than 50 then it returns error 400 along with message
		if (numberOfPassenger > 50) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Number of Passengers should not exceed 50. Enter Number of Passengers again!");

		}

		
		// if total available seats are less than the users requirement then it returns error 400 along with message

		int Maxseats=Integer.parseInt(MaxAvailableSeats);  
        
		if (Maxseats< numberOfPassenger) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Maximum Available Seats for particular route are " + MaxAvailableSeats
							+ ".Enter Number of Passengers less than or Equal to " + MaxAvailableSeats
							+ " and try Again!");
		}

		
		// calls availableBuses method of service layer

		return serviceLayer.availableBuses(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}
}