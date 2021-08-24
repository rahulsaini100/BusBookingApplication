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

@RestController
public class SearchController {

	private final ServiceLayer serviceLayer;


	@Autowired
	public SearchController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
		
	}

	@PostMapping(value = "/search")
	public List<AvailableBus> AvailableBuses(@RequestParam String fromCityName, @RequestParam String toCityName,
			@RequestParam Date journeyDate, @RequestParam long numberOfPassenger) {

		if (fromCityName.equals(toCityName)) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From city and To city can not be same. Choose Again");
		}
  
		Optional<City> cityOptional = serviceLayer.findByCityName(fromCityName);
		Optional<City> cityOptional1 = serviceLayer.findByCityName(toCityName);

		if (!cityOptional.isPresent() && !cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From And To city Not found in Our locations. Choose Any District from Haryana as locations!");

		}
		
		if (!cityOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From city Not found in our locations. Choose Any District from Haryana as From city!");

		}

		if (!cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"To city Not found in our locations. Choose Any District from Haryana as To city!");

		}
			
		String MaxAvailableSeats = serviceLayer.MaxAvailableSeats(fromCityName, toCityName, journeyDate);
		
		if (MaxAvailableSeats == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Oh Sorry. No Bus available on this route!");
		}

		if (numberOfPassenger > 50) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Number of Passengers should not exceed 50. Enter Number of Passengers again!");

		}

		int Maxseats=Integer.parseInt(MaxAvailableSeats);  
        
		if (Maxseats< numberOfPassenger) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Maximum Available Seats for particular route are " + MaxAvailableSeats
							+ ".Enter Number of Passengers less than or Equal to " + MaxAvailableSeats
							+ " and try Again!");
		}
 
		return serviceLayer.availableBuses(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}
}