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

@SpringBootTest
class UsersRepositoryTest {

	@Autowired
	private UsersRepository undertest;
	
	@Test
	void IfUserPresentfindByUserPhoneNumber_Test() {
		

		Optional<Users> userOptional= undertest.findUsersByUserPhoneNumber("8814056123");
		assertEquals(true, userOptional.isPresent());
	}
	@Test
	void IfUserNotPresentfindByUserPhoneNumber_Test() {
		

		Optional<Users> userOptional= undertest.findUsersByUserPhoneNumber("8814056128");
		assertEquals(false,userOptional.isPresent());
	}


}
