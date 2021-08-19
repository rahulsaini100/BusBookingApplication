package com.timesinternet.busbooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timesinternet.busbooking.entities.GenerateTicket;
import com.timesinternet.busbooking.services.ServiceLayer;

@RestController
public class MyBookingController {
	private final ServiceLayer serviceLayer;

	@Autowired
	public MyBookingController(ServiceLayer serviceLayer) {
		super();
		this.serviceLayer = serviceLayer;
	}

	@PostMapping(value = "/mybooking")
	public List<GenerateTicket> myBookingFn(@RequestParam long userId) {

		return serviceLayer.showBooking(userId);

	}
}
