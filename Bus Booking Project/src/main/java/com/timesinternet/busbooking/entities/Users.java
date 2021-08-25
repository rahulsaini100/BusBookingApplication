package com.timesinternet.busbooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User class represents user table in database It contains attributes userId,
 * userName, userPhoneNumber, userAddress
 * 
 * @author Vikas.Sahani
 *
 */

@Entity
@Table
public class Users {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	private String userName;
	private String userPhoneNumber;
	private String userAddress;

	/**
	 * default constructor
	 */
	public Users() {

	}

	/**
	 * constructs and initialize Users class without userId
	 * 
	 * @param userName
	 * @param userPhoneNumber
	 * @param userAddress
	 */
	public Users(String userName, String userPhoneNumber, String userAddress) {
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
	}

	/**
	 * constructs and initialize Users class with userId
	 * 
	 * @param userName
	 * @param userPhoneNumber
	 * @param userAddress
	 */
	public Users(long userId, String userName, String userPhoneNumber, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
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
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * sets userName
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return userPhoneNumber
	 */
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	/**
	 * sets userPhoneNumber
	 * 
	 * @param userPhoneNumber
	 */
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	/**
	 * 
	 * @return userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * sets userAddress
	 * 
	 * @param userAddress
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
