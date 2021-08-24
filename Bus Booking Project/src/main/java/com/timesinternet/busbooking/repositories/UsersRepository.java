package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	//This returns a boolean value that weather a Phone number exists in database or not
	Optional<Users> findUsersByUserPhoneNumber(String userPhoneNumber);
	
//	@Query("SELECT EXISTS(SELECT * from Users WHERE userPhoneNumber=?1);")
//	boolean existsByUserPhoneNumber(String userPhoneNumber);
}
