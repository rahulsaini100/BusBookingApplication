package com.timesinternet.busbooking.entities;

import java.sql.Time;
import java.util.*;

public class AvailableBus {

	private String busId;
	private Time arrivalTime;
	private Time departureTime;
	
	
	public AvailableBus(String busId, Time arrivalTime, Time departureTime) {
		this.busId = busId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time depastureTime) {
		this.departureTime = depastureTime;
	}
	
	
}
