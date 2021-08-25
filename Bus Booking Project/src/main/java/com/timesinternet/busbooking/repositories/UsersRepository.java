package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * UserRepository contains queries related to user's data 
 * @author Vikas.Sahani
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	/**
	 * This checks weather a Phone number exists in database or not
	 * @param userPhoneNumber
	 * @return
	 */

	Optional<Users> findUsersByUserPhoneNumber(String userPhoneNumber);
	
}
