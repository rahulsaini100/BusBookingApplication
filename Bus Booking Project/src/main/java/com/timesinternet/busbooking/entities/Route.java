package com.timesinternet.busbooking.entities;

import javax.persistence.*;
import java.sql.Time;

/**
 * Route class represents route table in database
 * It has attributes routeId, fromCityId, toCityId, departureTime, arrivalTime
 * @author Vikas.Sahani
 *
 */

@Entity
@Table
public class Route {
	@Id
	@Column(length = 5)
	private String routeId;
	private String fromCityId;
	private String toCityId;
	private Time departureTime;
	private Time arrivalTime;

	/**
	 * default constructor of Route class
	 */
	public Route() {
	}
	/**
	 * Constructs and initializes Route class 
	 * @param routeId
	 * @param fromCityId
	 * @param toCityId
	 * @param departureTime
	 * @param arrivalTime
	 */
	public Route(String routeId, String fromCityId, String toCityId, Time departureTime, Time arrivalTime) {
		this.routeId = routeId;
		this.fromCityId = fromCityId;
		this.toCityId = toCityId;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
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
	 * @param routeId
	 */
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	/**
	 * 
	 * @return fromCityId
	 */
	public String getFromCityId() {
		return fromCityId;
	}
	/**
	 * sets fromCityId
	 * @param fromCityId
	 */
	public void setFromCityId(String fromCityId) {
		this.fromCityId = fromCityId;
	}
	/**
	 * 
	 * @return toCityId
	 */
	public String getToCityId() {
		return toCityId;
	}
	/**
	 * sets toCityId
	 * @param toCityId
	 */
	public void setToCityId(String toCityId) {
		this.toCityId = toCityId;
	}
	/**
	 * 
	 * @return departureTime
	 */
	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
