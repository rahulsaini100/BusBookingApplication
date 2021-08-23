package com.timesinternet.busbooking.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.timesinternet.busbooking.repositories.CityRepository;
import com.timesinternet.busbooking.services.ServiceLayer;

@WebMvcTest(value = SearchController.class)
@WebAppConfiguration
class SearchControllerTest {

 
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceLayer undertest;
	
//	@BeforeEach
//	public void setup() {
//      
//		mockMvc =MockMvcBuilder
//
//    }
	
	@Test
	void FromAndToCitySame_BadRequest_Test() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/search?fromCityName=Ambala&toCityName=Ambala&journeyDate=2021-08-30&numberOfPassenger=5")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("From city and To city can not be same. Choose Again", message);

	}

	@Test
	void FromCityNotPresentInDatabase_BadRequest_Test() throws Exception {
		

//		when(undertest.findByCityName("Ludhiana")).thenReturn(Optional<City>());
//		when(undertest.findByCityName("Ambala"));

		MvcResult mvcResult = this.mockMvc.perform(post("/search?fromCityName=Ludhiana&"
				+ "toCityName=Ambala&journeyDate=2021-08-30&numberOfPassenger=5")).andReturn();
		

//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/search?fromCityName=Ludhiana&toCityName=Ambala&journeyDate=2021-08-30&numberOfPassenger=5")
//				.accept(MediaType.APPLICATION_JSON);

//		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("From city Not found in our locations. Choose Any District from Haryana as From city!", message);

	}

	@Test
	void ToCityNotPresentInDatabase_BadRequest_Test() throws Exception {
		
		MvcResult mvcResult = this.mockMvc.perform(post("/search?fromCityName=Ambala&toCityName=ludhiana&journeyDate=2021-08-30&numberOfPassenger=5")).andReturn();

//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/search?fromCityName=Ambala&toCityName=ludhiana&journeyDate=2021-08-30&numberOfPassenger=5")
//				.accept(MediaType.APPLICATION_JSON);

//		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("To city Not found in our locations. Choose Any District from Haryana as To city!", message);

	}

	@Test
	void FromCityAndToCityNotPresentInDatabase_BadRequest_Test() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/search?fromCityName=Patiala&toCityName=ludhiana&journeyDate=2021-08-30&numberOfPassenger=5")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		System.out.print(message);
		assertEquals("From And To city Not found in Our locations. Choose Any District from Haryana as locations!",
				message);

	}

	@Test
	void NoBusAvailable_BadRequest_Test() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/search?fromCityName=karnal&toCityName=Ambala&journeyDate=2021-08-30&numberOfPassenger=5")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		System.out.print(message);
		assertEquals("Oh Sorry. No Bus available on this route!", message);

	}
	@Test
	void checkstatus() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/search?fromCityName=Ambala&toCityName=Yamuna Nagar&journeyDate=2021-08-30&numberOfPassenger=5")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

}
