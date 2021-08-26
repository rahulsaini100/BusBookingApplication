package com.timesinternet.busbooking.testrepositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.timesinternet.busbooking.entities.AvailableBus;
import com.timesinternet.busbooking.repositories.BusRepository;

/**
 * Codes for testing of BusRepository class
 * 
 * @author Rahul.Saini
 *
 */
@SpringBootTest
class BusRepositoryTest {

	@Autowired
	private BusRepository undertest;

	/**
	 * Testing for FindRoute
	 */
	@Test

	void FindRouteMethod_Test() {

		String fromCityName = "Ambala";
		String toCityName = "Yamuna Nagar";
		Date journeyDate = Date.valueOf("2021-08-30");
		int numberOfPassenger = 5;

		List<Object[]> Allbuses = undertest.FindRoute(fromCityName, toCityName, journeyDate, numberOfPassenger);

		assertEquals(4, Allbuses.size());

	}

	/**
	 * Testing for FindMaxSeats
	 */
	@Test
	void FindMaxSeatsMethod_Test() {

		String fromCityName = "Ambala";
		String toCityName = "Yamuna Nagar";
		Date journeyDate = Date.valueOf("2021-08-30");

		String maxseats = undertest.MaxSeats(fromCityName, toCityName, journeyDate);

		assertEquals("40", maxseats);

	}

}
