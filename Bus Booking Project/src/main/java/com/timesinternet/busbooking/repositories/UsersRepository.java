package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findUsersByUserPhoneNumber(String userPhoneNumber);
    
}
