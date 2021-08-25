package com.timesinternet.busbooking.testcontrollers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.sql.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.timesinternet.busbooking.controllers.GenerateTicketController;
import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.entities.Ticket;
import com.timesinternet.busbooking.services.ServiceLayer;

@WebMvcTest(value = GenerateTicketController.class)
@WebAppConfiguration
class GenerateTicketControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceLayer undertest;

	@Test
	void GenerateTicketMethod_Test() throws Exception {

		GenerateTicket testobj = new GenerateTicket(7,12, "Robin", "8814056123", "Haryana, Kuk", "B14", "Panchkula",
				"Yamuna Nagar", Date.valueOf("2021-08-25"), Date.valueOf("2021-08-30"), 5, 2000);

		Mockito.when(undertest.ticketGeneration((Ticket) any(Ticket.class))).thenReturn(testobj);
		mockMvc.perform(post("/generateticket?userId=5&busId=B14&routeId=R13&numberOfSeats=5&journeyDate=2021-08-30&totalFare=2000"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.bookingId", is(7)))
				.andExpect(jsonPath("$.userId", is(12)))
				.andExpect(jsonPath("$.userName", is("Robin")))
				.andExpect(jsonPath("$.userPhonenumber", is("8814056123")))
				.andExpect(jsonPath("$.userAddress", is("Haryana, Kuk"))).andExpect(jsonPath("$.busId", is("B14")))
				.andExpect(jsonPath("$.startLocation", is("Panchkula")))
				.andExpect(jsonPath("$.endLocation", is("Yamuna Nagar")))
				.andExpect(jsonPath("$.dateOfBooking", is("2021-08-25")))
				.andExpect(jsonPath("$.journeyDate", is("2021-08-30"))).andExpect(jsonPath("$.numberOfSeats", is(5)))
				.andExpect(jsonPath("$.totalFare", is(2000))).andReturn();

	}
}
