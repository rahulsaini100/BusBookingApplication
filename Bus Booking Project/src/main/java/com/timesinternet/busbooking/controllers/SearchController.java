package com.timesinternet.busbooking.controllers;

import com.timesinternet.busbooking.services.*;

import com.timesinternet.busbooking.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.sql.Date;

/**
 * This controller contains url for search API
 * 
 * @author Rahul.Saini
 *
 */
@RestController
public class SearchController {

	private final ServiceLayer serviceLayer;

	/**
	 * constructor
	 * 
	 * @param serviceLayer
	 */
	@Autowired
	public SearchController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;

	}

	/**
	 * This is an endpoint which takes inputs , checks validation and if all the
	 * validations passes it returns list of AvailableBus
	 * 
	 * @param fromCityName
	 * @param toCityName
	 * @param journeyDate
	 * @param numberOfPassenger
	 * @return
	 */
	@PostMapping(value = "/search")
	public List<AvailableBus> AvailableBuses(@RequestParam String fromCityName, @RequestParam String toCityName,
			@RequestParam Date journeyDate, @RequestParam long numberOfPassenger) {
		/**
		 * checks if fromCityName and toCityName are same or different
		 */
		if (fromCityName.equals(toCityName)) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From city and To city can not be same. Choose Again");
		}

		/**
		 * checks if fromCityName is present in database or not
		 */

		Optional<City> cityOptional = serviceLayer.findByCityName(fromCityName);
		/**
		 * checks if toCityName is present in database or not
		 */
		Optional<City> cityOptional1 = serviceLayer.findByCityName(toCityName);

		/**
		 * returns error 400
		 */
		if (!cityOptional.isPresent() && !cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From And To city Not found in Our locations. Choose Any District from Haryana as locations!");

		}

		/**
		 * returns error 400
		 */
		if (!cityOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From city Not found in our locations. Choose Any District from Haryana as From city!");

		}
		/**
		 * returns error 400
		 */
		if (!cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"To city Not found in our locations. Choose Any District from Haryana as To city!");

		}
		/**
		 * finds maximum available seats
		 */
		String MaxAvailableSeats = serviceLayer.MaxAvailableSeats(fromCityName, toCityName, journeyDate);

		/**
		 * returns error 400
		 */
		if (MaxAvailableSeats == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Oh Sorry. No Bus available on this route!");
		}
		/**
		 * returns error 400
		 */
		if (numberOfPassenger > 50) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Number of Passengers should not exceed 50. Enter Number of Passengers again!");

		}

		int Maxseats = Integer.parseInt(MaxAvailableSeats);

		/**
		 * returns error 400
		 */
		if (Maxseats < numberOfPassenger) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Maximum Available Seats for particular route are " + MaxAvailableSeats
							+ ".Enter Number of Passengers less than or Equal to " + MaxAvailableSeats
							+ " and try Again!");
		}

		return serviceLayer.availableBuses(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}
}