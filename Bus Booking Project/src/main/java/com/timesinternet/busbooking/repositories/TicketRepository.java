package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("select new com.timesinternet.busbooking.entities.GenerateTicket(t.bookingId,u.userName,"
			+ " u.userPhoneNumber,u.userAddress,t.busId,(select cityName from City where cityId=r.fromCityId),"
			+ "(select cityName from City where cityId=r.toCityId),t.dateOfBooking,t.journeyDate,t.numberOfSeats,"
			+ "p.ticketPrice*t.numberOfSeats)" + " from Ticket as t INNER join Users as u on t.userId=u.userId "
			+ "INNER JOIN Route as r on t.routeId=r.routeId " + "INNER JOIN Price as p on r.routeId=p.routeId "
			+ "where t.bookingId=?1")
	GenerateTicket FindTicket(long bookingId);
	
	@Query("select new com.timesinternet.busbooking.entities.GenerateTicket(t.bookingId,u.userName,"
			+ " u.userPhoneNumber,u.userAddress,t.busId,(select cityName from City where cityId=r.fromCityId),"
			+ "(select cityName from City where cityId=r.toCityId),t.dateOfBooking,t.journeyDate,t.numberOfSeats,"
			+ "p.ticketPrice*t.numberOfSeats)" + " from Ticket as t INNER join Users as u on t.userId=u.userId "
			+ "INNER JOIN Route as r on t.routeId=r.routeId " + "INNER JOIN Price as p on r.routeId=p.routeId "
			+ "where u.userId=?1")

	List<GenerateTicket> allTicket(long userId);

}

