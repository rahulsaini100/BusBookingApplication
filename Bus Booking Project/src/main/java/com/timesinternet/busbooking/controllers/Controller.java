package com.timesinternet.busbooking.controllers;
import com.timesinternet.busbooking.services.*;

import com.timesinternet.busbooking.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {

  private final ServiceLayer serviceLayer;

  @Autowired
  public Controller(ServiceLayer serviceLayer) {
    this.serviceLayer = serviceLayer;
  }


  @PostMapping(value = "/search")
    public List<abc> AvailableBuses(
          @RequestParam String fromCityName,
          @RequestParam String toCityName
          ){

      return serviceLayer.availableBuses(fromCityName,toCityName);

  }

}
