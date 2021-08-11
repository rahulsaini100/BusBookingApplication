package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<AvailableBus, String> {

	@Query("SELECT new com.timesinternet.busbooking.entities.AvailableBus(b.busId,r.arrivalTime,r.departureTime,b.busType,"
			+ "b.busProvider,p.ticketPrice,s.totalSeat,s.totalSeat-IFNULL(t.numberOfSeats,0),r.routeId) "
			+ "from Bus as b INNER JOIN Route as r on b.routeId=r.routeId "
			+ "INNER JOIN Price as p on p.routeId=b.routeId " + "INNER JOIN Seat as s on s.busId=b.busId"
			+ " LEFT JOIN Ticket as t on t.busId=s.busId and t.journeyDate=?3 "
			+ "WHERE r.fromCityId=(SELECT cityId from City where cityname=?1) "
			+ "and r.toCityId=(SELECT cityId from City where cityname=?2) and s.totalSeat-IFNULL(t.numberOfSeats,0)>=?4")
	List<AvailableBus> FindRoute(String fromCityName, String toCityName, Date journeyDate, long numberOfPassenger);

}
