package com.timesinternet.busbooking.Controllers;

import com.timesinternet.busbooking.Entities.Bus;
import com.timesinternet.busbooking.Services.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.util.*;

@RestController
public class Controller {

  private final ServiceLayer serviceLayer;

  @Autowired
  public Controller(ServiceLayer serviceLayer) {
    this.serviceLayer = serviceLayer;
  }


  @PostMapping(value = "/search")
    public List<Bus> AvailableBuses(
          @RequestParam String fromCityId,
          @RequestParam String toCityId
          ){

      return serviceLayer.availableBuses(fromCityId,toCityId);

  }

}
