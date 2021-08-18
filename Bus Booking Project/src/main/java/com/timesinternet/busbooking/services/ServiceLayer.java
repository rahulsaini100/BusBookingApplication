package com.timesinternet.busbooking.services;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.BusRepository;
import com.timesinternet.busbooking.repositories.CityRepository;
import com.timesinternet.busbooking.repositories.TicketRepository;

import com.timesinternet.busbooking.repositories.UsersRepository;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

//import java.util.Date;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {

	private final BusRepository busRepository;
	private final UsersRepository usersRepository;
	private final TicketRepository ticketRepository;
	

	@Autowired
	public ServiceLayer(BusRepository busRepository, UsersRepository usersRepository,
			TicketRepository ticketRepository) {
		this.busRepository = busRepository;
		this.usersRepository = usersRepository;
		this.ticketRepository = ticketRepository;
		
	}


	public List<AvailableBus> availableBuses(String fromCityName, String toCityName, Date journeyDate,
			long numberOfPassenger) {	
		
		return busRepository.FindRoute(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}

	public long addNewUser(Users u) {

		Optional<Users> usersOptional = usersRepository.findUsersByUserPhoneNumber(u.getUserPhoneNumber());

		if (usersOptional.isPresent()) {
			throw new IllegalStateException("Number already Registered. Use a different number");
		}
		if(u.getUserPhoneNumber().length()!=10) {
			throw new IllegalStateException("Phone number should be of 10 digits");
		}
		if(u.getUserName().length()>25) {
			throw new IllegalStateException("User Name should be less than 25 characters");
		}
		if(u.getUserAddress().length()>100) {
			throw new IllegalStateException("User Address should be less than 100 characters");
		}

		usersRepository.save(u);
		long id = u.getUserId();
		return id;
 
	}

	public List<GenerateTicket> showBooking(long userId) {

		return ticketRepository.allTicket(userId);
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
