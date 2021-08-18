package com.timesinternet.busbooking.repositories;

import com.timesinternet.busbooking.entities.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface CityRepository extends JpaRepository<City,String> {
	
      Optional<City> findByCityName(String cityName);
}
