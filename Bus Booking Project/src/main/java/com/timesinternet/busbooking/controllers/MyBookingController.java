package com.timesinternet.busbooking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.repositories.TicketRepository;

import com.timesinternet.busbooking.services.ServiceLayer;

/**
 * This is a controller class which contains url for the myBooking API
 * It takes userId as a input and returns List of ticket booked by that user
 * @author Vikas.Sahani
 *
 */
@RestController
public class MyBookingController {
	private final ServiceLayer serviceLayer;
	private final TicketRepository ticketRepository;
	/**
	 * constructor of MyBookingController class
	 * @param serviceLayer
	 * @param ticketRepository
	 */
	@Autowired
	public MyBookingController(ServiceLayer serviceLayer, TicketRepository ticketRepository) {
		super();
		this.serviceLayer = serviceLayer;
		this.ticketRepository = ticketRepository;
	}

	/**
	 * this endpoint takes input userPhoneNumber and returns list of Tickets booked over that input
	 * @param userPhoneNumber
	 * @return
	 */
	@PostMapping(value = "/mybooking")
	public List<GenerateTicket> myBookingFn(@RequestParam String userPhoneNumber) {
		
		return serviceLayer.showBooking(userPhoneNumber);

	}
}
