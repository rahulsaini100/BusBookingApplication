package com.timesinternet.busbooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Price class represents price table in our database It has attributes routeId
 * and ticketPrice
 * 
 * @author Vikas.Sahani
 *
 */

@Entity
@Table
public class Price {
	@Id
	@Column(length = 5)
	private String routeId;
	private Long ticketPrice;

	/**
	 * Default constructor
	 */
	public Price() {

	}

	/**
	 * Constructs and initializes the Price class
	 * 
	 * @param routeId
	 * @param ticketPrice
	 */
	public Price(String routeId, Long ticketPrice) {
		super();
		this.routeId = routeId;
		this.ticketPrice = ticketPrice;
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
	 * @return ticketPrice
	 */
	public Long getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * set ticketPrice
	 * 
	 * @param ticketPrice
	 */
	public void setTicketPrice(Long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
