package com.timesinternet.busbooking.testcontrollers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.timesinternet.busbooking.controllers.MyBookingController;
import com.timesinternet.busbooking.entities.GenerateTicket;

import com.timesinternet.busbooking.services.ServiceLayer;

/**
 * Codes for testing of MyBookingController class
 * @author Rahul.Saini
 *
 */
@WebMvcTest(value = MyBookingController.class)
@WebAppConfiguration
class MyBookingControllerTest {

	@Autowired
	private MockMvc mockMvc;
	/**
	 * Mocking the ServiceLayer
	 */
	@MockBean
	private ServiceLayer undertest;
	/**
	 * Testing the ShowMyBooking class
	 * @throws Exception
	 */
	@Test
	void ShowMybookingMethod_Test() throws Exception {

		List<GenerateTicket> Mybookings = new ArrayList<GenerateTicket>();
		GenerateTicket booking1 = new GenerateTicket(7, "Robin", "8814056123", "Haryana, Kuk", "B14", "Panchkula",
				"Yamuna Nagar", Date.valueOf("2021-08-25"), Date.valueOf("2021-08-30"), 5, 2000);
		GenerateTicket booking2 = new GenerateTicket(8, "Robin", "8814056123", "Haryana, Kuk", "B15", "Panchkula",
				"Yamuna Nagar", Date.valueOf("2021-08-26"), Date.valueOf("2021-08-30"), 5, 2000);

		Mybookings.add(booking1);
		Mybookings.add(booking2);

		Mockito.when(undertest.showBooking("8814056123")).thenReturn(Mybookings);
		MvcResult mvcResult = mockMvc.perform(post("/mybooking?userPhoneNumber=8814056123")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].bookingId", is(7))).andExpect(jsonPath("$[0].userName", is("Robin")))
				.andExpect(jsonPath("$[0].userPhonenumber", is("8814056123")))
				.andExpect(jsonPath("$[0].userAddress", is("Haryana, Kuk")))
				.andExpect(jsonPath("$[0].busId", is("B14"))).andExpect(jsonPath("$[0].startLocation", is("Panchkula")))
				.andExpect(jsonPath("$[0].endLocation", is("Yamuna Nagar")))
				.andExpect(jsonPath("$[0].dateOfBooking", is("2021-08-25")))
				.andExpect(jsonPath("$[0].journeyDate", is("2021-08-30")))
				.andExpect(jsonPath("$[0].numberOfSeats", is(5))).andExpect(jsonPath("$[0].totalFare", is(2000)))
				.andExpect(jsonPath("$[1].bookingId", is(8))).andExpect(jsonPath("$[1].userName", is("Robin")))
				.andExpect(jsonPath("$[1].userPhonenumber", is("8814056123")))
				.andExpect(jsonPath("$[1].userAddress", is("Haryana, Kuk")))
				.andExpect(jsonPath("$[1].busId", is("B15"))).andExpect(jsonPath("$[1].startLocation", is("Panchkula")))
				.andExpect(jsonPath("$[1].endLocation", is("Yamuna Nagar")))
				.andExpect(jsonPath("$[1].dateOfBooking", is("2021-08-26")))
				.andExpect(jsonPath("$[1].journeyDate", is("2021-08-30")))
				.andExpect(jsonPath("$[1].numberOfSeats", is(5))).andExpect(jsonPath("$[1].totalFare", is(2000)))
				.andReturn();

		JSONArray jsonArray = new JSONArray(mvcResult.getResponse().getContentAsString());

		assertEquals(2, jsonArray.length());
	
	}

}
