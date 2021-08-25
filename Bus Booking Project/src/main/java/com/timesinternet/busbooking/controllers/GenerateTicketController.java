package com.timesinternet.busbooking.controllers;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.entities.Ticket;
import com.timesinternet.busbooking.services.ServiceLayer;

/**
 * This is a controller class which contains url for generateTicket API
 * 
 * @author Rahul.Saini
 *
 */
@RestController
public class GenerateTicketController {

	private final ServiceLayer serviceLayer;

	@Autowired
	public GenerateTicketController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}

	/**
	 * generateTicket API takes input and returns a generateTicket type object which
	 * the help of a method ticketGeneration of service layer
	 * 
	 * @param userId
	 * @param busId
	 * @param routeId
	 * @param numberOfSeats
	 * @param journeyDate
	 * @return
	 */
	@PostMapping(value = "/generateticket")
	public GenerateTicket generateTicket(@RequestParam long userId, @RequestParam String busId,
			@RequestParam String routeId, @RequestParam long numberOfSeats, @RequestParam Date journeyDate) {
		Ticket ticket = new Ticket(userId, busId, routeId, numberOfSeats, journeyDate);
		return serviceLayer.ticketGeneration(ticket);
	}

}
