package com.timesinternet.busbooking.controllers;

import com.timesinternet.busbooking.services.*;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.sql.Date;

import java.sql.Date;
import java.util.regex.Pattern;

@RestController
public class Controller {

	private final ServiceLayer serviceLayer;
	private final UsersRepository usersRepository;

	@Autowired
	public Controller(ServiceLayer serviceLayer, UsersRepository usersRepository) {
		this.serviceLayer = serviceLayer;
		this.usersRepository = usersRepository;
	}

	@PostMapping(value = "/search")
	public List<AvailableBus> AvailableBuses(@RequestParam String fromCityName, @RequestParam String toCityName,
			@RequestParam Date journeyDate, @RequestParam long numberOfPassenger) {

		return serviceLayer.availableBuses(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}

	@PostMapping(value = "/saveuser")
	public long updateUserAndTicketTable(@RequestParam String userName, @RequestParam String userPhoneNumber,
			@RequestParam String userAddress) {
		
		Users u = new Users(userName, userPhoneNumber, userAddress);

		Optional<Users> usersOptional = usersRepository.findUsersByUserPhoneNumber(u.getUserPhoneNumber());

		boolean numberCheck = Pattern.matches("[0-9]+", u.getUserPhoneNumber());

		boolean nameCheck = Pattern.matches("[a-zA-Z\\s]+", u.getUserName());

		if (usersOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Number already Registered. Use a different number");
		}

		if (nameCheck == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Name should contain letters a-z , A-Z and spaces only");
		}

		if (numberCheck == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User number should contain digits 0-9 only");
		}
		if (u.getUserPhoneNumber().length() != 10) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User number should be of 10 digits");
		}

		if (u.getUserName().length() > 25) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Name should be less than 25 characters");
		}
		if (u.getUserAddress().length() > 100) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Address should be less than 100 characters");
		}
		
		return serviceLayer.addNewUser(u);
	}

	@PostMapping(value = "/mybooking")
	public List<GenerateTicket> myBookingFn(@RequestParam long userId) {

		return serviceLayer.showBooking(userId);

	}

	@PostMapping(value = "/generateticket")
	public GenerateTicket generateTicket(@RequestParam long userId, @RequestParam String busId,
			@RequestParam String routeId, @RequestParam long numberOfSeats, @RequestParam Date journeyDate) {
		Ticket ticket = new Ticket(userId, busId, routeId, numberOfSeats, journeyDate);
		return serviceLayer.ticketGeneration(ticket);
	}
}
