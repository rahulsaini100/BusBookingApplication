package com.timesinternet.busbooking.testrepositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.timesinternet.busbooking.entities.AvailableBus;
import com.timesinternet.busbooking.repositories.BusRepository;

@SpringBootTest
class BusRepositoryTest {

	@Autowired
	private BusRepository undertest;

	@Test
	void FindRoute_Test() {

		String fromCityName = "Ambala";
		String toCityName = "Yamuna Nagar";
		Date journeyDate = Date.valueOf("2021-08-30");
		long numberOfPassenger = 5;

		List<AvailableBus> Allbuses = undertest.FindRoute(fromCityName, toCityName, journeyDate, numberOfPassenger);

		assertEquals(4, Allbuses.size());

	}

	@Test
	void FindMaxSeats_Test() {

		String fromCityName = "Ambala";
		String toCityName = "Yamuna Nagar";
		Date journeyDate = Date.valueOf("2021-08-30");

		String maxseats = undertest.MaxSeats(fromCityName, toCityName, journeyDate);

		assertEquals("40", maxseats);

	}

}
