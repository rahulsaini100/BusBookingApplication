package com.timesinternet.busbooking.entities;

import java.util.Date;


public class abc {
	private String busId;
	private Date arrivalTime;
	private Date departureTime;
	
	
	public abc(String busId, Date arrivalTime, Date departureTime) {
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
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date depastureTime) {
		this.departureTime = depastureTime;
	}
	

}
