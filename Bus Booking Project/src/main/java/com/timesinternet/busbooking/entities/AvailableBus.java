package com.timesinternet.busbooking.entities;

import java.sql.Time;
import java.util.Date;


/**
 * AvailableBus class represents the class whose object will be pass when user
 * will search for buses of his/her requirement
 * 
 * @author Rahul.Saini
 *
 */
public class AvailableBus {

	private String busId;
	private Time departureTime;
	private Time arrivalTime;
	private String busType;
	private String busProvider;
	private Object ticketPrice;
	private Object totalSeats;
	private Object availableSeat;
	private String routeId;

	/**
	 * default constructor
	 */
	public AvailableBus() {
		super();
	}

	/**
	 * constructs and initializes AvailableBus class
	 * 
	 * @param busId
	 * @param arrivalTime
	 * @param departureTime
	 * @param busType
	 * @param busProvider
	 * @param ticketPrice
	 * @param totalSeats
	 * @param availableSeat
	 * @param routeId
	 */
	public AvailableBus(String busId, Time arrivalTime, Time departureTime, String busType, String busProvider,
			Object ticketPrice, Object totalSeats, Object availableSeat, String routeId) {
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

	/**
	 * 
	 * @return totalSeats
	 */
	public Object getTotalSeats() {
		return totalSeats;
	}

	/**
	 * sets totalSeats
	 * 
	 * @param totalSeats
	 */
	public void setTotalSeats(Object totalSeats) {
		this.totalSeats = totalSeats;
	}

	/**
	 * 
	 * @return busId
	 */
	public String getBusId() {
		return busId;
	}

	/**
	 * sets busId
	 * 
	 * @param busId
	 */
	public void setBusId(String busId) {
		this.busId = busId;
	}

	/**
	 * 
	 * @return arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * sets arrivalTime
	 * 
	 * @param arrivalTime
	 */
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * 
	 * @return departureTime
	 */
	public Date getDepartureTime() {
		return departureTime;
	}

	/**
	 * sets departureTime
	 * 
	 * @param depastureTime
	 */
	public void setDepartureTime(Time depastureTime) {
		this.departureTime = depastureTime;
	}

	/**
	 * 
	 * @return busType
	 */
	public String getbusType() {
		return busType;
	}

	/**
	 * sets busType
	 * 
	 * @param busType
	 */
	public void setbusType(String busType) {
		this.busType = busType;
	}

	/**
	 * 
	 * @return busProvider
	 */
	public String getbusProvider() {
		return busProvider;
	}

	/**
	 * sets busProvider
	 * 
	 * @param busProvider
	 */
	public void setbusProvider(String busProvider) {
		this.busProvider = busProvider;
	}

	/**
	 * 
	 * @return ticketPrice
	 */
	public Object getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * sets ticketPrice
	 * 
	 * @param ticketPrice
	 */
	public void setTicketPrice(Object ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	/**
	 * 
	 * @return availableSeat
	 */
	public Object getAvailableSeat() {
		return availableSeat;
	}

	/**
	 * sets availableSeat
	 * 
	 * @param availableSeat
	 */
	public void setAvailableSeat(Object availableSeat) {
		this.availableSeat = availableSeat;
	}

	/**
	 * 
	 * @return routeId
	 */
	public String getRouteId() {
		return routeId;
	}

	/**
	 * sets routeId
	 * 
	 * @param routeId
	 */
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

}
