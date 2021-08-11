package com.timesinternet.busbooking.services;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.BusRepository;
import com.timesinternet.busbooking.repositories.TicketRepository;
import com.timesinternet.busbooking.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {

    private final BusRepository busRepository;
    private final UsersRepository usersRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public ServiceLayer(BusRepository busRepository, UsersRepository usersRepository, TicketRepository ticketRepository) {
        this.busRepository = busRepository;
		this.usersRepository = usersRepository;
		this.ticketRepository = ticketRepository;
    }

    public List<abc> availableBuses(String fromCityName, String toCityName) {

    return  busRepository.FindRoute(fromCityName,toCityName);

    }
    /////////////////////////////////////////////////////////////////////////////////


	public long addNewUser(Users u) {
		 
		Optional<Users> usersOptional = usersRepository.findUsersByUserPhoneNumber(u.getUserPhoneNumber());
		
		if(usersOptional.isPresent()) {
			throw new IllegalStateException("Number already Registered. Use a different number");
		}
		
		usersRepository.save(u);
		long id = u.getUserId();
		return id;
		
	}

	public List<Ticket> showBooking(long userId) {
		
		return ticketRepository.allTicket(userId);
	}
    
}
