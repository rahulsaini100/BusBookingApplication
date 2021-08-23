package com.timesinternet.busbooking.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BusRepositoryTest {

	@Autowired
	private BusRepository undertest;

	@Test
	void testFindRoute() {

		String fromCityName = "Ambala";
		String toCityName = "Yamuna Nagar";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2021, 8, 30);
		Date journeyDate = calendar.getTime();
		long numberOfPassenger = 5;

		assertThat(undertest.FindRoute(fromCityName, toCityName, journeyDate, numberOfPassenger)).isNotEmpty();

	}


}
