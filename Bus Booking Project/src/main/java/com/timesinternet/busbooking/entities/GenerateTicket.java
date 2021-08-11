package com.timesinternet.busbooking.entities;

import java.util.Date;

public class GenerateTicket {

	private long bookingId;
	private String userName;
	private String userPhonenumber;
	private String userAddress;
	private String busId;
	private String startLocation;
	private String endLocation;
	private Date dateOfBooking;
	private Date journeyDate;
	private long numberOfSeats;
	private long totalFare;

	public GenerateTicket() {
		super();
	}

	public GenerateTicket(long bookingId, String userName, String userPhonenumber, String userAddress, String busId,
			String startLocation, String endLocation, Date dateOfBooking, Date journeyDate, long numberOfSeats,
			long totalFare) {
		super();
		this.bookingId = bookingId;
		this.userName = userName;
		this.userPhonenumber = userPhonenumber;
		this.userAddress = userAddress;
		this.busId = busId;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.dateOfBooking = dateOfBooking;
		this.journeyDate = journeyDate;
		this.numberOfSeats = numberOfSeats;
		this.totalFare = totalFare;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhonenumber() {
		return userPhonenumber;
	}

	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public long getnumberOfSeats() {
		return numberOfSeats;
	}

	public void setnumberOfSeats(long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public long getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(long totalFare) {
		this.totalFare = totalFare;
	}

	public Date getjourneyDate() {
		return journeyDate;
	}

	public void setjourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

}
