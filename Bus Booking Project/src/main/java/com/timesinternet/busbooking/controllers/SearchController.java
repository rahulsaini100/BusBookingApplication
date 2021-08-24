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
	private final CityRepository cityRepository;

	@Autowired
	public SearchController(ServiceLayer serviceLayer, CityRepository cityRepository) {
		this.serviceLayer = serviceLayer;
		this.cityRepository = cityRepository;
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

		Optional<City> cityOptional = cityRepository.findByCityName(fromCityName);
		Optional<City> cityOptional1 = cityRepository.findByCityName(toCityName);
		
		// If there is no such cities in database than it returns error 400 along with message
		if (!cityOptional.isPresent() && !cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No bus Available from city to To city. Choose your citites again!");

		}
		// If there is no such city in database as source city then it returns error 400 along with message
		if (!cityOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No bus Start from this city. Choose your From city again!");

		}

		// If there is no such city in database as destination city then it returns error 400 along with message
		if (!cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No Bus goes to this Location. Choose your To city again!");

		}

		// If number of passengers is greater than 50 then it returns error 400 along with message
		if (numberOfPassenger > 50) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Number of Passengers should not exceed 50. Enter Number of Passengers again!");

		}
		
		// to find maximum available seat in bus
		long MaxAvailableSeats = serviceLayer.MaxAvailableSeats(fromCityName, toCityName, journeyDate);
		
		// if total available seats are less than the users requirement then it returns error 400 along with message
		if (MaxAvailableSeats < numberOfPassenger) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Maximum Available Seats for particular route are " + MaxAvailableSeats
							+ ".Enter Number of Passengers less than or Equal to " + MaxAvailableSeats
							+ " and try Again!");
		}
		
		// calls availableBuses method of service layer
		return serviceLayer.availableBuses(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}
}