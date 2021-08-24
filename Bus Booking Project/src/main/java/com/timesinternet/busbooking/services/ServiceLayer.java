package com.timesinternet.busbooking.services;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.BusRepository;
import com.timesinternet.busbooking.repositories.CityRepository;
import com.timesinternet.busbooking.repositories.TicketRepository;

import com.timesinternet.busbooking.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {

	private final BusRepository busRepository;
	private final UsersRepository usersRepository;
	private final TicketRepository ticketRepository;
	private final CityRepository cityRepository;

	@Autowired
	public ServiceLayer(BusRepository busRepository, UsersRepository usersRepository,
			TicketRepository ticketRepository,CityRepository cityRepository) {
		this.busRepository = busRepository;
		this.usersRepository = usersRepository;
		this.ticketRepository = ticketRepository;
		this.cityRepository = cityRepository;
		

	}

	public List<AvailableBus> availableBuses(String fromCityName, String toCityName, Date journeyDate,
			long numberOfPassenger) {

		return busRepository.FindRoute(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}

	public long addNewUser(Users u) {

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

	public String MaxAvailableSeats(String fromCityName, String toCityName, Date journeyDate) {

		return busRepository.MaxSeats(fromCityName, toCityName, journeyDate);
	}

	public Optional<City> findByCityName(String fromCityName) {
		
		return 	cityRepository.findByCityName(fromCityName);
		
	
	}

	public Optional<Users> findUsersByUserPhoneNumber(String userPhoneNumber) {

		return usersRepository.findUsersByUserPhoneNumber(userPhoneNumber);
	}
	
}
