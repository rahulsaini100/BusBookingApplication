package com.timesinternet.busbooking.services;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.BusRepository;
import com.timesinternet.busbooking.repositories.CityRepository;
import com.timesinternet.busbooking.repositories.TicketRepository;
import com.timesinternet.busbooking.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * It contains methods which interacts with controllers and repositories
 * @author Rahul.Saini and Vikas.Sahani
 *
 */
@Service
public class ServiceLayer {

	private BusRepository busRepository;
	private UsersRepository usersRepository;
	private TicketRepository ticketRepository;
	private CityRepository cityRepository;
	/**
	 * constructs and initializes the ServiceLayer class
	 * @param busRepository
	 * @param usersRepository
	 * @param ticketRepository
	 * @param cityRepository
	 */
	@Autowired
	public ServiceLayer(BusRepository busRepository, UsersRepository usersRepository,
			TicketRepository ticketRepository,CityRepository cityRepository) {
		this.busRepository = busRepository;
		this.usersRepository = usersRepository;
		this.ticketRepository = ticketRepository;
		this.cityRepository = cityRepository;
		

	}
	
	/**
	 * returns list of AvailableBus with the halp of FindRoute method of busRepository
	 * @param fromCityName
	 * @param toCityName
	 * @param journeyDate
	 * @param numberOfPassenger
	 * @return
	 */
	public List<Object[]> availableBuses(String fromCityName, String toCityName, Date journeyDate,
			int numberOfPassenger) {

		return busRepository.FindRoute(fromCityName, toCityName, journeyDate, numberOfPassenger);

	}
	/**
	 * adds new user to database  
	 * @param users object
	 * @return userId
	 */
	public long addNewUser(Users u) {

		usersRepository.save(u);
		long id = u.getUserId();
		return id;

	}
	
	/**
	 * shows all the tickets booked by that userPhonenumber
	 * @param userPhoneNumber
	 * @return list of ticket
	 */
	public List<GenerateTicket> showBooking(String userPhoneNumber) {

		return ticketRepository.allTicket(userPhoneNumber);
	}
	/**
	 * generates the ticket with the help of FindTicket method of ticketRepository
	 * @param ticket
	 * @return
	 */
	public GenerateTicket ticketGeneration(Ticket ticket) {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		ticket.setDateOfBooking(date);
		ticketRepository.save(ticket);
		long bookingId = ticket.getBookingId();
		return ticketRepository.FindTicket(bookingId);

	}
	
	/**
	 * finds maximum available seats with the help of MaxSeat method of busRepository
	 * @param fromCityName
	 * @param toCityName
	 * @param journeyDate
	 * @return maximum available seats 
	 */

	public String MaxAvailableSeats(String fromCityName, String toCityName, Date journeyDate) {
	
		return busRepository.MaxSeats(fromCityName, toCityName, journeyDate);
	}
	
	/**
	 * finds weather a city is present in database or not
	 * @param fromCityName
	 * @return boolean
	 */
	public Optional<City> findByCityName(String fromCityName) {
		
		return 	cityRepository.findByCityName(fromCityName);
		
	
	}

	public Optional<Users> findUsersByUserPhoneNumber(String userPhoneNumber) {

		return usersRepository.findUsersByUserPhoneNumber(userPhoneNumber);
	}
	
}
