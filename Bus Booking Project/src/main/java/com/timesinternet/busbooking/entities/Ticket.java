package com.timesinternet.busbooking.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ticket {
	@Id
	
	private String bookingId;
	private String userId;
	private String busId;
	private int numberofTicket;
	private Date dateOfBooking;
	
	public Ticket() {
		
	}

	public Ticket(String bookingId, String userId, String busId, int numberofTicket, Date dateOfBooking) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.busId = busId;
		this.numberofTicket = numberofTicket;
		this.dateOfBooking = dateOfBooking;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public int getNumberofTicket() {
		return numberofTicket;
	}

	public void setNumberofTicket(int numberofTicket) {
		this.numberofTicket = numberofTicket;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	
	

}
