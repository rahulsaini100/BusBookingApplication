package com.timesinternet.busbooking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.entities.Ticket;
import com.timesinternet.busbooking.repositories.TicketRepository;
import com.timesinternet.busbooking.services.ServiceLayer;

@RestController
public class MyBookingController {
	private final ServiceLayer serviceLayer;
	private final TicketRepository ticketRepository;
	@Autowired
	public MyBookingController(ServiceLayer serviceLayer, TicketRepository ticketRepository) {
		super();
		this.serviceLayer = serviceLayer;
		this.ticketRepository = ticketRepository;
	}
	// This API takes userId as input and returns list of ticket booked by the user.
	// It uses showBooking method of service layer and passes userId as input
	
	@PostMapping(value = "/mybooking")
	public List<GenerateTicket> myBookingFn(@RequestParam long userId) {
		
//		Optional<Ticket> ticketOptional = ticketRepository.findTicketByUserId(userId);
//		
//		if(ticketOptional.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//					"No booking for this userId. Enter a valid userId");
//		}

		return serviceLayer.showBooking(userId);

	}
	
	@PostMapping(value = "/mybooking2")
	public List<GenerateTicket> myBookingFn2(@RequestParam String userPhoneNumber) {
		
		return serviceLayer.showBooking2(userPhoneNumber);

	}
}
