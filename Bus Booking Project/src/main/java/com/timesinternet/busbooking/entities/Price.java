package com.timesinternet.busbooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Price {
	@Id
	@Column(length = 5)
	private String routeId;
	private Long ticketPrice;

	public Price() {

	}

	public Price(String routeId, Long ticketPrice) {
		super();
		this.routeId = routeId;
		this.ticketPrice = ticketPrice;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Long getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
