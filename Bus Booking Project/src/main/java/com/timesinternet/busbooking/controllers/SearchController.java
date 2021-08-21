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
	private final CityRepository cityRepository;

	@Autowired
	public SearchController(ServiceLayer serviceLayer, CityRepository cityRepository) {
		this.serviceLayer = serviceLayer;
		this.cityRepository = cityRepository;
	}

	@PostMapping(value = "/search")
	public List<AvailableBus> AvailableBuses(@RequestParam String fromCityName, @RequestParam String toCityName,
			@RequestParam Date journeyDate, @RequestParam long numberOfPassenger) {

		if (fromCityName.equals(toCityName)) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"From city and To city can not be same. Choose Again");
		}

		Optional<City> cityOptional = cityRepository.findByCityName(fromCityName);
		Optional<City> cityOptional1 = cityRepository.findByCityName(toCityName);

		if (!cityOptional.isPresent() && !cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No bus Available from city to To city. Choose your citites again!");

		}
		if (!cityOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No bus Start from this city. Choose your From city again!");

		}

		if (!cityOptional1.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No Bus goes to this Location. Choose your To city again!");

		}

		if (numberOfPassenger > 50) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Number of Passengers should not exceed 50. Enter Number of Passengers again!");

		}

		long MaxAvailableSeats = serviceLayer.MaxAvailableSeats(fromCityName, toCityName, journeyDate);

		if (MaxAvailableSeats < numberOfPassenger) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Maximum Available Seats for particular route are " + MaxAvailableSeats
							+ ".Enter Number of Passengers less than or Equal to " + MaxAvailableSeats
							+ " and try Again!");
		}

		return serviceLayer.availableBuses(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}
}