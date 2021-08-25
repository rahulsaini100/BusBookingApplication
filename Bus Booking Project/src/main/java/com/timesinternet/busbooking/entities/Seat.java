package com.timesinternet.busbooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Seat class represents seat table in database It has attributes busId and
 * totalSeat
 * 
 * @author Vikas.Sahani
 *
 */
@Entity
@Table
public class Seat {

	@Id
	@Column(length = 5)
	private String busId;
	private Long totalSeat;

	/**
	 * default constructor
	 */
	public Seat() {

	}

	/**
	 * constructs and initializes Seat class
	 * 
	 * @param busId
	 * @param totalSeat
	 */
	public Seat(String busId, Long totalSeat) {
		super();
		this.busId = busId;
		this.totalSeat = totalSeat;
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
	 * @return totalSeat
	 */
	public Long getTotalSeat() {
		return totalSeat;
	}

	/**
	 * sets totalSeat
	 * 
	 * @param totalSeat
	 */
	public void setTotalSeat(Long totalSeat) {
		this.totalSeat = totalSeat;
	}

}
