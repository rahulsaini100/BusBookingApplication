package com.timesinternet.busbooking.testrepositories;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.repositories.TicketRepository;

@SpringBootTest
class TicketRepositoryTest {

	@Autowired
	private TicketRepository undertest;

	@Test
	void FindTicketByBookingid_Test() {

		GenerateTicket Expected = new GenerateTicket(3,3, "krishna", "8814056456", "Delhi,NCR", "B21", "Ambala",
				"Yamuna Nagar", Date.valueOf("2021-08-20"), Date.valueOf("2021-08-21"), 10, 3500);
		GenerateTicket Actual = undertest.FindTicket(3);
		assertEquals(Expected.getBookingId(), Actual.getBookingId());
		assertEquals(Expected.getUserName(), Actual.getUserName());
		assertEquals(Expected.getUserAddress(), Actual.getUserAddress());
		assertEquals(Expected.getUserPhonenumber(), Actual.getUserPhonenumber());
		assertEquals(Expected.getBusId(), Actual.getBusId());
		assertEquals(Expected.getStartLocation(), Actual.getStartLocation());
		assertEquals(Expected.getEndLocation(), Actual.getEndLocation());
		assertEquals(Expected.getDateOfBooking(), Actual.getDateOfBooking());
		assertEquals(Expected.getjourneyDate(), Actual.getjourneyDate());
		assertEquals(Expected.getnumberOfSeats(), Actual.getnumberOfSeats());
		assertEquals(Expected.getTotalFare(), Actual.getTotalFare());

	}

	@Test
	void FindAllBookingsByPhoneNumber_Test() {

		List<GenerateTicket> AllBookings = undertest.allTicket("8814056123");

		assertEquals(3, AllBookings.size());

	}
}
