package com.timesinternet.busbooking.entities;

import java.io.Serializable; 
import java.util.*;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bookingId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	
	@Column(name="busId")
	private String busId;
	
	@Column(name="userId")
	private long userId;
	
	
	@Column(name="routeId")
	private String routeId;
	
	@Column(name="numberOfSeats")
	private long numberOfSeats;
	
	@Column(name="dateOfBooking")
	private Date dateOfBooking;
	
	@Column(name="journeyDate")
	private Date journeyDate;
	
	
	
	public Ticket() {
		
	}



	public Ticket(int bookingId, String busId, long userId, String routeId, long numberOfSeats, Date dateOfBooking,
			Date journeyDate) {
		super();
		this.bookingId = bookingId;
		this.busId = busId;
		this.userId = userId;
		this.routeId = routeId;
		this.numberOfSeats = numberOfSeats;
		this.dateOfBooking = dateOfBooking;
		this.journeyDate = journeyDate;
	}



	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public String getBusId() {
		return busId;
	}



	public void setBusId(String busId) {
		this.busId = busId;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getRouteId() {
		return routeId;
	}



	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}



	public long getNumberOfSeats() {
		return numberOfSeats;
	}



	public void setNumberOfSeats(long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}



	public Date getDateOfBooking() {
		return dateOfBooking;
	}



	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}



	public Date getJourneyDate() {
		return journeyDate;
	}



	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

	
	
	
	
//	public Ticket(String busId, int numberofTicket, Date dateOfBooking) {
//		//this.userId = bookingId;
//		this.busId = busId;
//		this.numberofTicket = numberofTicket;
//		this.dateOfBooking = dateOfBooking;
//	}
//
//	public Ticket(int bookingId, int userId, String busId, int numberofTicket, Date dateOfBooking) {
//		super();
//		this.bookingId = bookingId;
//		this.userId = userId;
//		this.busId = busId;
//		this.numberofTicket = numberofTicket;
//		this.dateOfBooking = dateOfBooking;
//	}
//
////	public Ticket(String busId, int numberOfTicket, java.util.Date dateOfBooking) {
////		// TODO Auto-generated constructor stub
////		this.userId = bookingId;
////		this.busId = busId;
////		this.numberofTicket = numberofTicket;
////		this.dateOfBooking = dateOfBooking;
////		
////	}
//
//	public long getBookingId() {
//		return bookingId;
//	}
//
//	public void setBookingId(int bookingId) {
//		this.bookingId = bookingId;
//	}
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getBusId() {
//		return busId;
//	}
//
//	public void setBusId(String busId) {
//		this.busId = busId;
//	}
//
//	public int getNumberofTicket() {
//		return numberofTicket;
//	}
//
//	public void setNumberofTicket(int numberofTicket) {
//		this.numberofTicket = numberofTicket;
//	}
//
//	public Date getDateOfBooking() {
//		return dateOfBooking;
//	}
//
//	public void setDateOfBooking(Date dateOfBooking) {
//		this.dateOfBooking = dateOfBooking;
//	}
//	
	

}
