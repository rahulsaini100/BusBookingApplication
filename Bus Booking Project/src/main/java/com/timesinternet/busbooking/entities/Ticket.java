package com.timesinternet.busbooking.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	private long userId;
	private String busId;
	private long numberOfSeats;
	private Date dateOfBooking;
	private Date journeyDate;
	private String routeId;

	public Ticket(long userId, String busId, String routeId, long numberOfSeats, Date journeyDate) {
		super();
		this.userId = userId;
		this.busId = busId;
		this.numberOfSeats = numberOfSeats;
		this.journeyDate = journeyDate;
		this.routeId = routeId;
	}

	public Ticket(long bookingId, long userId, String busId, long numberOfSeats, Date dateOfBooking, Date journeyDate,
			String routeId) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.busId = busId;
		this.numberOfSeats = numberOfSeats;
		this.dateOfBooking = dateOfBooking;
		this.journeyDate = journeyDate;
		this.routeId = routeId;
	}

	public Ticket() {

	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public long getnumberOfSeats() {
		return numberOfSeats;
	}

	public void setnumberOfSeats(long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Date getjourneyDate() {
		return journeyDate;
	}

	public void setjourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

}
