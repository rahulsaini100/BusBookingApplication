package com.timesinternet.busbooking.testrepositories;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.timesinternet.busbooking.entities.AvailableBus;
import com.timesinternet.busbooking.entities.City;

import com.timesinternet.busbooking.repositories.CityRepository;

/**
 * Codes for testing of CityRepository class
 * @author Rahul.Saini
 *
 */
@SpringBootTest
class CityRepositoryTest {

	@Autowired
	private CityRepository undertest;
	/**
	 * Testing if City is present  
	 */
	@Test
	void IfCityPresentFindByCityName_Test() {
		

		Optional<City> cityOptional= undertest.findByCityName("Ambala");

		assertEquals(true, cityOptional.isPresent());
	}

	/**
	 * Testing if city is not present
	 */
	@Test
	void IfCityNotPresentFindByCityName_Test() {
		

		Optional<City> cityOptional= undertest.findByCityName("Ludhiana");

		assertEquals(false, cityOptional.isPresent());
	}
	
}
