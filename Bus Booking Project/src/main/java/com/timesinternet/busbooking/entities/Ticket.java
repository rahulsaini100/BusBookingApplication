package com.timesinternet.busbooking.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ticket table represents ticket table in the database It has attributes
 * bookingId, userId, busId, numberOfSeats, dateOfBooking, journeyDate and
 * routeId
 * 
 * @author Vikas.Sahani
 *
 */

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
	private long totalFare;

	/**
	 * constructor without bookingId
	 * 
	 * @param userId
	 * @param busId
	 * @param routeId
	 * @param numberOfSeats
	 * @param journeyDate
	 */
	public Ticket(long userId, String busId, String routeId, long numberOfSeats, Date journeyDate, long totalFare) {
		super();
		this.userId = userId;
		this.busId = busId;
		this.numberOfSeats = numberOfSeats;
		this.journeyDate = journeyDate;
		this.routeId = routeId;
		this.totalFare=totalFare;
	}

	/**
	 * constructor with bookingId
	 * 
	 * @param bookingId
	 * @param userId
	 * @param busId
	 * @param numberOfSeats
	 * @param dateOfBooking
	 * @param journeyDate
	 * @param routeId
	 */
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

	/**
	 * default constructor
	 */
	public Ticket() {

	}

	/**
	 * 
	 * @return bookingId
	 */
	public long getBookingId() {
		return bookingId;
	}

	/**
	 * sets nookingId
	 * 
	 * @param bookingId
	 */
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * 
	 * @return userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * sets userId
	 * 
	 * @param userId
	 */
	public void setUserId(long userId) {
		this.userId = userId;
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
	 * @return numberOfSeats
	 */
	public long getnumberOfSeats() {
		return numberOfSeats;
	}

	/**
	 * sets numberOfSeats
	 * 
	 * @param numberOfSeats
	 */
	public void setnumberOfSeats(long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	/**
	 * 
	 * @return dateOfBooking
	 */
	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	/**
	 * sets dateOfBooking
	 * 
	 * @param dateOfBooking
	 */
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
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
	 * @return journeyDate
	 */
	public Date getjourneyDate() {
		return journeyDate;
	}

	/**
	 * sets journeydate
	 * 
	 * @param journeyDate
	 */
	public void setjourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public long getTotalfare() {
		return totalFare;
	}
	public void setTotalfare(long totalfare) {
		this.totalFare = totalfare;
	}

}