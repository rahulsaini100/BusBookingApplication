package com.timesinternet.busbooking.entities;

import java.util.Date;

/**
 * GenerateTicket class is used to have all the details in ticket
 * It has attributes bookingId, userName, userPhoneNumber, userAddress, busId, startLocation, endLocation, dateOfBooking,
 * journeyDate, numberOfSeats and totalFare
 * @author Rahul.Saini
 *
 */
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

	
	/**
	 * default constructor 
	 */
	public GenerateTicket() {
		super();
	}
	/**
	 * constructs and initializes GenerateTicket class
	 * @param bookingId
	 * @param userName
	 * @param userPhonenumber
	 * @param userAddress
	 * @param busId
	 * @param startLocation
	 * @param endLocation
	 * @param dateOfBooking
	 * @param journeyDate
	 * @param numberOfSeats
	 * @param totalFare
	 */
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

	/**
	 * 
	 * @return bookingId
	 */
	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 * @return userPhoneNumber
	 */
	public String getUserPhonenumber() {
		return userPhonenumber;
	}

	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}
	/**
	 * 
	 * @return userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
	 * 
	 * @return busId
	 */
	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}
	/**
	 * 
	 * @return dateOfBooking
	 */
	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	/**
	 * 
	 * @return numberOfSeats
	 */
	public long getnumberOfSeats() {
		return numberOfSeats;
	}

	public void setnumberOfSeats(long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	/**
	 * 
	 * @return startLocation
	 */
	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	
	/**
	 * 
	 * @return endLocation
	 */
	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	/**
	 * 
	 * @return totalFare
	 */
	public long getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(long totalFare) {
		this.totalFare = totalFare;
	}
	/**
	 * 
	 * @return journeyDate
	 */
	public Date getjourneyDate() {
		return journeyDate;
	}

	public void setjourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

}
