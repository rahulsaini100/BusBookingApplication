package com.timesinternet.busbooking.Entities;

import org.hibernate.annotations.GenericGenerator;

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
	private Long TicketPrice;
	
	public Price() {
		
	}

	public Price(String routeId, Long ticketPrice) {
		super();
		this.routeId = routeId;
		TicketPrice = ticketPrice;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Long getTicketPrice() {
		return TicketPrice;
	}

	public void setTicketPrice(Long ticketPrice) {
		TicketPrice = ticketPrice;
	}
	
	
	
}
