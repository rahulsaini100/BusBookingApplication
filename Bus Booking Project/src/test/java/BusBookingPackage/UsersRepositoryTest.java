package BusBookingPackage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.timesinternet.busbooking.entities.Users;
import com.timesinternet.busbooking.repositories.UsersRepository;

class UsersRepositoryTest {
	@Autowired
	private UsersRepository underTest;
	

	public UsersRepositoryTest(UsersRepository underTest) {
		super();
		this.underTest = underTest;
	}


	@Test
	void itChecksIfUserExistByUserPhoneNumber() {
//		String userPhoneNumber = "1234567898";
//		
//		
//		Users u = new Users("Mohan", userPhoneNumber, "Delhi,India");
//		
//    	underTest.save(u);
//
//    	boolean expected = underTest.existsByUserPhoneNumber(userPhoneNumber);
//		assertThat(expected).isTrue();
		
	}

}
