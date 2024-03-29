package com.timesinternet.busbooking.testservices;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.timesinternet.busbooking.entities.AvailableBus;
import com.timesinternet.busbooking.entities.City;
import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.entities.Ticket;
import com.timesinternet.busbooking.entities.Users;
import com.timesinternet.busbooking.repositories.BusRepository;
import com.timesinternet.busbooking.repositories.CityRepository;
import com.timesinternet.busbooking.repositories.TicketRepository;
import com.timesinternet.busbooking.repositories.UsersRepository;
import com.timesinternet.busbooking.services.ServiceLayer;

/**
 * Codes for testing of ServiceLayer class
 * 
 * @author Rahul.Saini
 *
 */
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class ServiceLayerTest {

	@InjectMocks
	ServiceLayer serviceLayer;
	/**
	 * Mocking the busRepository
	 */
	@MockBean
	BusRepository busRepository;
	/**
	 * Mocking the usersRepository
	 */
	@MockBean
	UsersRepository usersRepository;
	/**
	 * Mocking the ticketRepository
	 */
	@MockBean
	TicketRepository ticketRepository;
	/**
	 * Mocking the cityRepository
	 */
	@MockBean
	CityRepository cityRepository;
	/**
	 * Test for addNewUser
	 */
	@Test
	void AddNewUsermethod_Test() {

		Users u = new Users("Rahul", "8814099999", "Haryana, Kurukshetra");
		u.setUserId(7L);

		Mockito.when(usersRepository.save(u)).thenReturn(u);

		long result = serviceLayer.addNewUser(u);

		assertEquals(7, result);

	}

	/**
	 * Test for showBooking method
	 */
	@Test
	void ShowBookingsMethod_Test() {

		List<GenerateTicket> Mybookings = new ArrayList<GenerateTicket>();
		GenerateTicket booking1 = new GenerateTicket(7,12, "Robin", "8814056123", "Haryana, Kuk", "B14", "Panchkula",
				"Yamuna Nagar", Date.valueOf("2021-08-25"), Date.valueOf("2021-08-30"), 5, 2000);
		GenerateTicket booking2 = new GenerateTicket(8,12, "Robin", "8814056123", "Haryana, Kuk", "B15", "Panchkula",
				"Yamuna Nagar", Date.valueOf("2021-08-26"), Date.valueOf("2021-08-30"), 5, 2000);

		Mybookings.add(booking1);
		Mybookings.add(booking2);

		Mockito.when(ticketRepository.allTicket("8814056123")).thenReturn(Mybookings);

		List<GenerateTicket> expected = serviceLayer.showBooking("8814056123");

		assertEquals(2, expected.size());

	}

	/**
	 * Test for GenerateTicket
	 */
	@Test
	void TicketGenerateMethod_Test() {

		Ticket ticket = new Ticket(5, "B14", "R13", 5, Date.valueOf("2021-08-30"),2000);
		ticket.setBookingId(7L);
		GenerateTicket Expected= new GenerateTicket(7,12, "Robin", "8814056123", "Haryana, Kuk", "B14", "Panchkula",
				"Yamuna Nagar", Date.valueOf("2021-08-25"), Date.valueOf("2021-08-30"), 5, 2000);
		Mockito.when(ticketRepository.save(ticket)).thenReturn(ticket);
		Mockito.when(ticketRepository.FindTicket(ticket.getBookingId())).thenReturn(Expected);
		GenerateTicket Actual = serviceLayer.ticketGeneration(ticket);

		assertEquals(Expected, Actual);

	}

	/**
	 * Test for FindCityByName method
	 */
	@Test
	void FindByCityNameMethod_Test() {

		City c = new City();
		c.setCityName("Ambala");
		Optional<City> expected = Optional.of(c);
		Mockito.when(cityRepository.findByCityName("Ambala")).thenReturn(expected);

		Optional<City> actual = serviceLayer.findByCityName("Ambala");

		assertEquals(expected.get(), actual.get());

	}

	/**
	 * Test for FindUsersByUserPhoneNumber method
	 */
	@Test
	void FindUsersByUserPhoneNumberMethod_Test() {

		Users testobj = new Users();
		testobj.setUserAddress("8814056123");
		Optional<Users> expected = Optional.of(testobj);
		Mockito.when(usersRepository.findUsersByUserPhoneNumber("8814056123")).thenReturn(expected);
		Optional<Users> actual = serviceLayer.findUsersByUserPhoneNumber("8814056123");
		assertEquals(expected.get(), actual.get());

	}

}
