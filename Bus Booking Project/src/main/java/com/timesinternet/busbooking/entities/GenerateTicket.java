package com.timesinternet.busbooking.entities;

import java.util.Date;

public class GenerateTicket {
	private long userId;
	private String userName;
	private String userPhoneNumber;
	private String userAddress;
	private String busId;
	private String startLocation;
	private String endLocation;
	private Date dateOfBooking;
	private Date journeyDate;
	private long numberOfSeats;
	private long totalFare;

	
	public GenerateTicket(long userId, String userName, String userPhoneNumber, String userAddress, String busId,
			String startLocation, String endLocation, Date dateOfBooking, Date journeyDate, long numberOfSeats,
			long totalFare) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
		this.busId = busId;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.dateOfBooking = dateOfBooking;
		this.journeyDate = journeyDate;
		this.numberOfSeats = numberOfSeats;
		this.totalFare = totalFare;
	}

	//long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	//java.lang.String, java.util.Date, java.util.Date, long, long

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
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

	public long getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public long getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(long totalFare) {
		this.totalFare = totalFare;
	}

	// int, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	// java.lang.String, java.lang.String, java.util.Date, java.util.Date, long,
	// long

}
