package com.timesinternet.busbooking.Services;

import com.timesinternet.busbooking.Entities.Bus;
import com.timesinternet.busbooking.Repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceLayer {

    private final BusRepository busRepository;

    @Autowired
    public ServiceLayer(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> availableBuses(String fromCityId, String toCityId) {

    return  busRepository.FilterBus(fromCityId,toCityId);

    }
}
