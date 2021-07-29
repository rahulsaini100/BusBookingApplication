package com.timesinternet.busbooking.services;

import com.timesinternet.busbooking.entities.*;
import com.timesinternet.busbooking.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceLayer {

    private final BusRepository busRepository;

    @Autowired
    public ServiceLayer(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<abc> availableBuses(String fromCityName, String toCityName) {

    return  busRepository.FindRoute(fromCityName,toCityName);

    }
}
