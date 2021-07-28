package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

    @Query("SELECT new com.timesinternet.busbooking.Entities.abc(b.busId,r.arrivalTime,r.departureTime) \n"
    		+ "from Bus as b INNER JOIN Route as r on b.routeId=r.routeId\n"
    		+ "WHERE r.fromCityId=(SELECT cityId from City where cityname=?1)\n "
    		+ "and r.toCityId=(SELECT cityId from City where cityname=?2)")
    
    List<abc>FindRoute(String fromCityName, String toCityName);
    	
    
    
}
