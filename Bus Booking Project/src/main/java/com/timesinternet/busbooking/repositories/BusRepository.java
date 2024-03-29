package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;


/**
 * BusRepository contains queries related to buses and bookings
 * 
 * @author Rahul.Saini
 *
 */
@Repository
public interface BusRepository extends JpaRepository<Bus, String> {

	/**
	 * This query returns all the routes available on the basis of user's need
	 * 
	 * @param fromCityName
	 * @param toCityName
	 * @param journeyDate
	 * @param numberOfPassenger
	 * @return
	 */
	@Query(nativeQuery = true,value="SELECT b.busId,r.arrivalTime,r.departureTime,b.busType,b.busProvider,p.ticketPrice,s.totalSeat,"
			+ "s.totalSeat-SUM(IFNULL(t.numberOfSeats,0)),r.routeId "
			+ "from Bus as b INNER JOIN Route as r on b.routeId=r.routeId "
			+ "INNER JOIN Price as p on p.routeId=b.routeId "
			+ "INNER JOIN Seat as s on s.busId=b.busId "
			+ "LEFT JOIN Ticket as t on t.busId=s.busId and t.journeyDate=?3 "
			+ "WHERE r.fromCityId=(SELECT cityId from City where cityname=?1) "
			+ "and r.toCityId=(SELECT cityId from City where cityname=?2) "
			+ "GROUP BY b.busId "
			+ "HAVING s.totalSeat-SUM(IFNULL(t.numberOfSeats,0))>=?4")
	List<Object[]> FindRoute(String fromCityName, String toCityName, Date journeyDate, int numberOfPassenger);

	/**
	 * This query returns the maximum number of seats left on a bus on the input of
	 * source city, destination city & journey date
	 * 
	 * @param fromCityName
	 * @param toCityName
	 * @param journeyDate
	 * @return
	 */
	@Query(nativeQuery = true,value="SELECT  s.totalSeat-SUM(IFNULL(t.numberOfSeats,0)) "
			+ "from Bus as b INNER JOIN Route as r on b.routeId=r.routeId "
			+ "INNER JOIN Price as p on p.routeId=b.routeId "
			+ "INNER JOIN Seat as s on s.busId=b.busId "
			+ "LEFT JOIN Ticket as t on t.busId=s.busId and t.journeyDate=?3 "
			+ "WHERE r.fromCityId=(SELECT cityId from City where cityname=?1) "
			+ "and r.toCityId=(SELECT cityId from City where cityname=?2) "
			+ "GROUP BY b.busId "
			+ "order by s.totalSeat-SUM(IFNULL(t.numberOfSeats,0)) desc limit 1")
	String MaxSeats(String fromCityName, String toCityName, Date journeyDate);


}
