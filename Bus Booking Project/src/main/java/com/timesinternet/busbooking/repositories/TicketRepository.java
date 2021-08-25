package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TicketRepository contains queries related to ticket
 * @author Rahul.Saini and Vikas.Sahani
 *
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	/**
	 * returns the ticket after the confirmation of booking
	 * @param bookingId
	 * @return
	 */
	@Query("select new com.timesinternet.busbooking.entities.GenerateTicket(t.bookingId,u.userId,u.userName,"
			+ " u.userPhoneNumber,u.userAddress,t.busId,(select cityName from City where cityId=r.fromCityId),"
			+ "(select cityName from City where cityId=r.toCityId),t.dateOfBooking,t.journeyDate,t.numberOfSeats,"
			+ "t.totalFare)" + " from Ticket as t INNER join Users as u on t.userId=u.userId "
			+ "INNER JOIN Route as r on t.routeId=r.routeId "
			+ "where t.bookingId=?1")
	GenerateTicket FindTicket(long bookingId);

	/**
	 * returns list of all ticket booked by a userPhoneNumber	
	 * @param userPhoneNumber
	 * @return
	 */
	@Query("select new com.timesinternet.busbooking.entities.GenerateTicket(t.bookingId,u.userId,u.userName,"
			+ " u.userPhoneNumber,u.userAddress,t.busId,(select cityName from City where cityId=r.fromCityId),"
			+ "(select cityName from City where cityId=r.toCityId),t.dateOfBooking,t.journeyDate,t.numberOfSeats,"
			+ "t.totalFare)" + " from Ticket as t INNER join Users as u on t.userId=u.userId "
			+ "INNER JOIN Route as r on t.routeId=r.routeId "
			+ "where u.userPhoneNumber=?1")

	List<GenerateTicket> allTicket(String userPhoneNumber);
	

}
