package com.timesinternet.busbooking.testcontrollers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import com.timesinternet.busbooking.controllers.SearchController;
import com.timesinternet.busbooking.entities.City;
import com.timesinternet.busbooking.services.ServiceLayer;

/**
 * Codes for testing of SearchController class
 * 
 * @author Rahul.Saini
 *
 */
@WebMvcTest(value = SearchController.class)
@WebAppConfiguration
class SearchControllerTest {

	@Autowired
	private MockMvc mockMvc;
	/**
	 * Mocking the ServiceLayer
	 */
	@MockBean
	private ServiceLayer undertest;

	/**
	 * Testing weather fromCityName and toCityName are same
	 * 
	 * @throws Exception
	 */
	@Test
	void FromAndToCitySame_BadRequest_Test() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(post(
						"/search?fromCityName=Ambala&toCityName=Ambala&journeyDate=2021-08-30&numberOfPassenger=5"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("From city and To city can not be same. Choose Again", message);

	}

	/**
	 * Testing weather fromCity present in databaase or not
	 * 
	 * @throws Exception
	 */
	@Test
	void FromCityNotPresentInDatabase_BadRequest_Test() throws Exception {
		City c = new City();
		c.setCityName("Ambala");
		Optional<City> obj = Optional.of(c);
		Mockito.when(undertest.findByCityName("Ambala")).thenReturn(obj);
		MvcResult mvcResult = mockMvc.perform(
				post("/search?fromCityName=Ludhiana&" + "toCityName=Ambala&journeyDate=2021-08-30&numberOfPassenger=5"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("From city Not found in our locations. Choose Any District from Haryana as From city!", message);

	}

	/**
	 * Testing weather toCityName is present on database or not
	 * 
	 * @throws Exception
	 */
	@Test
	void ToCityNotPresentInDatabase_BadRequest_Test() throws Exception {
		City c = new City();
		c.setCityName("Ambala");
		Optional<City> obj = Optional.of(c);
		Mockito.when(undertest.findByCityName("Ambala")).thenReturn(obj);
		MvcResult mvcResult = mockMvc
				.perform(post(
						"/search?fromCityName=Ambala&toCityName=ludhiana&journeyDate=2021-08-30&numberOfPassenger=5"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("To city Not found in our locations. Choose Any District from Haryana as To city!", message);

	}

	/**
	 * Testing weather fromCityName and toCityName is present in database or not
	 * 
	 * @throws Exception
	 */
	@Test
	void FromCityAndToCityNotPresentInDatabase_BadRequest_Test() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(post(
						"/search?fromCityName=Patiala&toCityName=ludhiana&journeyDate=2021-08-30&numberOfPassenger=5"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("From And To city Not found in Our locations. Choose Any District from Haryana as locations!",
				message);
	}

	/**
	 * Testing the availability of bus
	 * 
	 * @throws Exception
	 */
	@Test
	void NoBusAvailable_BadRequest_Test() throws Exception {

		City c = new City();
		City c1 = new City();
		c.setCityName("karnal");
		c1.setCityName("Yamuna Nagar");
		Optional<City> obj = Optional.of(c);
		Optional<City> obj1 = Optional.of(c1);
		Mockito.when(undertest.findByCityName("Karnal")).thenReturn(obj);
		Mockito.when(undertest.findByCityName("Yamuna Nagar")).thenReturn(obj1);
		Mockito.when(undertest.MaxAvailableSeats("karnal", "Yamuna Nagar", new Date(2021 - 8 - 30))).thenReturn(null);
		MvcResult mvcResult = mockMvc.perform(
				post("/search?fromCityName=Karnal&toCityName=Yamuna Nagar&journeyDate=2021-08-30&numberOfPassenger=5"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("Oh Sorry. No Bus available on this route!", message);

	}

}
