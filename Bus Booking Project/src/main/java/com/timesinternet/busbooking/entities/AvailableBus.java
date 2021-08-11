package com.timesinternet.busbooking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AvailableBus {
	@Id
	private String busId;
	private Date departureTime;
	private Date arrivalTime;
	private String busType;
	private String busProvider;
	private long ticketPrice;
	private long totalSeats;
	private long availableSeat;
	private String routeId;

	public AvailableBus() {
		super();
	}

	public AvailableBus(String busId, Date arrivalTime, Date departureTime, String busType, String busProvider,
			long ticketPrice, long totalSeats, long availableSeat, String routeId) {
		super();
		this.busId = busId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.busType = busType;
		this.busProvider = busProvider;
		this.ticketPrice = ticketPrice;
		this.totalSeats = totalSeats;
		this.availableSeat = availableSeat;
		this.routeId = routeId;
	}

	public long getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(long totalSeats) {
		this.totalSeats = totalSeats;
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

	public String getbusType() {
		return busType;
	}

	public void setbusType(String busType) {
		this.busType = busType;
	}

	public String getbusProvider() {
		return busProvider;
	}

	public void setbusProvider(String busProvider) {
		this.busProvider = busProvider;
	}

	public long getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public long getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(long availableSeat) {
		this.availableSeat = availableSeat;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

}
