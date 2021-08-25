package com.timesinternet.busbooking.entities;

import javax.persistence.*;

/**
 * Bus represents bus in database It has the attributes busId, routeId, busType
 * and busProvider
 * 
 * @author Rahul.Saini
 *
 */

@Entity
@Table
public class Bus {

	@Id
	@Column(length = 5)
	private String busId;
	private String routeId;
	private String busType;
	private String busProvider;

	/**
	 * default constructor
	 */
	public Bus() {
	}

	/**
	 * Constructs and initializes the Bus class
	 * 
	 * @param busId
	 * @param routeId
	 * @param busType
	 * @param busProvider
	 */
	public Bus(String busId, String routeId, String busType, String busProvider) {
		super();
		this.busId = busId;
		this.routeId = routeId;
		this.busType = busType;
		this.busProvider = busProvider;
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

	/**
	 * 
	 * @return busProvider
	 */
	public String getBusProvider() {
		return busProvider;
	}

	/**
	 * sets busProvider
	 * 
	 * @param busProvider
	 */
	public void setBusProvider(String busProvider) {
		this.busProvider = busProvider;
	}

	/**
	 * 
	 * @return busType
	 */
	public String getBusType() {
		return busType;
	}

	/**
	 * sets busType
	 * 
	 * @param busType
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}
}
