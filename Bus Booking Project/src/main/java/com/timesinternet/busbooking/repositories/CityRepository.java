package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TicketRepository contains queries related to ticket
 * 
 * @author Rahul.Saini
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, String> {

	/**
	 * This checks weather a city is present in database or not
	 * 
	 * @param cityName
	 * @return
	 */
	Optional<City> findByCityName(String cityName);
}
