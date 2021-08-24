package com.timesinternet.busbooking.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.entities.Ticket;
import com.timesinternet.busbooking.services.ServiceLayer;


@WebMvcTest(value =GenerateTicketController.class)
@WebAppConfiguration
class GenerateTicketControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceLayer undertest;

	@Test
	void checkstatus() throws Exception {
   
	String jsonResponse="{\"bookingId\":6,\"userName\":\"Robin\",\"userPhonenumber\":\"8814056123\",\"userAddress\":\"Haryana, Kuk\",\"busId\":\"B14\",\"startLocation\":\"Panchkula\",\"endLocation\":\"Yamuna Nagar\",\"dateOfBooking\":\"2021-08-23\",\"journeyDate\":\"2021-08-30\",\"numberOfSeats\":5,\"totalFare\":2000}";
     when(undertest.ticketGeneration(new Ticket())).thenReturn(new GenerateTicket());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/generateticket?userId=5&busId=B14&routeId=R13&numberOfSeats=5&journeyDate=2021-08-30")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
	
	}
}
