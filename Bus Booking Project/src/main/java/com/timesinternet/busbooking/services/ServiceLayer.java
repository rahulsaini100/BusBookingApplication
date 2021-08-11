package com.timesinternet.busbooking.services;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.BusRepository;
import com.timesinternet.busbooking.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

import java.util.List;

@Service
public class ServiceLayer {

	private final BusRepository busRepository;
	private final TicketRepository ticketRepository;

	@Autowired
	public ServiceLayer(BusRepository busRepository, TicketRepository ticketRepository) {
		this.busRepository = busRepository;
		this.ticketRepository = ticketRepository;
	}

	public List<AvailableBus> availableBuses(String fromCityName, String toCityName, Date journeyDate,
			long numberOfPassenger) {

		return busRepository.FindRoute(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}

	public GenerateTicket ticketGeneration(Ticket ticket) {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		ticket.setDateOfBooking(date);
		ticketRepository.save(ticket);
		long bookingId = ticket.getBookingId();
		return ticketRepository.FindTicket(bookingId);

	}
}
