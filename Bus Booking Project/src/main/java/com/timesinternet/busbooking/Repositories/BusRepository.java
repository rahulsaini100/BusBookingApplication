package com.timesinternet.busbooking.Repositories;

import com.timesinternet.busbooking.Entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

    @Query("SELECT r from Route r where r.fromCityId=?1 and r.toCityId=?2 ")
    List<Bus> FilterBus(String fromCityId, String toCityId);
}
