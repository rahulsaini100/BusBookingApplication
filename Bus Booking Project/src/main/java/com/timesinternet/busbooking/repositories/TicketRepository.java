package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

//    @Query("SELECT new com.timesinternet.busbooking.entities.abc(b.busId,r.arrivalTime,r.departureTime) \n"
//    		+ "from Bus as b INNER JOIN Route as r on b.routeId=r.routeId\n"
//    		+ "WHERE r.fromCityId=(SELECT cityId from City where cityname=?1)\n "
//    		+ "and r.toCityId=(SELECT cityId from City where cityname=?2)")
//    
//    List<abc>FindRoute(String fromCityName, String toCityName);
	
	@Query("select new com.timesinternet.busbooking.entities.Ticket(t.bookingId,t.busId,t.userId,t.routeId,t.numberOfSeats,t.dateOfBooking,t.journeyDate) \n"
			+ "from Ticket as t where t.userId=?1")
	
//	@Query("select new com.timesinternet.busbooking.entities.GenerateTicket(t.userId,u.userName,"
//			+ " u.userPhoneNumber,u.userAddress,t.busId,(select cityName from City where cityId=r.fromCityId),"
//			+ "(select cityName from City where cityId=r.toCityId),t.dateOfBooking,t.journeyDate,t.numberOfSeats,"
//			+ "p.TicketPrice*t.numberOfSeats)" + " from Ticket as t INNER join Users as u on t.userId=u.userId "
//			+ "INNER JOIN Route as r on t.routeId=r.routeId " + "INNER JOIN Price as p on r.routeId=p.routeId "
//			+ "where t.bookingId=?1")
	
	
			
	List<Ticket> allTicket(long userId);
    
    
    
}