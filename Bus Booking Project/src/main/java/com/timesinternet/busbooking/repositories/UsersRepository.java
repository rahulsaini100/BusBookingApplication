package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	Optional<Users> findUsersByUserPhoneNumber(String userPhoneNumber);
}
