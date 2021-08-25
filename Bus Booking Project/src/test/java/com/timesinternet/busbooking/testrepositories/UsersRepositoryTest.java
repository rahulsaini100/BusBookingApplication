package com.timesinternet.busbooking.testrepositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.timesinternet.busbooking.entities.City;
import com.timesinternet.busbooking.entities.Users;
import com.timesinternet.busbooking.repositories.CityRepository;
import com.timesinternet.busbooking.repositories.UsersRepository;

/**
 * Codes for testing of UsersRepository class
 * @author Rahul.Saini
 *
 */
@SpringBootTest
class UsersRepositoryTest {

	@Autowired
	private UsersRepository undertest;
	
	/**
	 * Testing for userPhoneNumber exists 
	 */
	@Test
	void IfUserPresentfindByUserPhoneNumber_Test() {
		

		Optional<Users> userOptional= undertest.findUsersByUserPhoneNumber("8814056123");
		assertEquals(true, userOptional.isPresent());
	}
	/**
	 * Testing for userPhoneNumber not exists 
	 */
	@Test
	void IfUserNotPresentfindByUserPhoneNumber_Test() {
		

		Optional<Users> userOptional= undertest.findUsersByUserPhoneNumber("8814056128");
		assertEquals(false,userOptional.isPresent());
	}


}
