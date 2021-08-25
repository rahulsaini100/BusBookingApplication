package com.timesinternet.busbooking.controllers;

import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.timesinternet.busbooking.entities.Users;

import com.timesinternet.busbooking.services.ServiceLayer;

/**
 * This is a controller class which contains url for saveuser API It saves the
 * details of the user in database in user Table
 * 
 * @author Vikas.Sahani
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SaveUserController {

	private final ServiceLayer serviceLayer;

	@Autowired
	public SaveUserController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}

	/**
	 * following endpoint is called after the user books a bus. User is asked to
	 * give his/her details as input parameter of this API and the API will return
	 * an auto generated user ID. There are some validations over the inputs like ,
	 * 
	 * 
	 * If any validation fails we pass an status 400 and ask user to give valid
	 * input.
	 * 
	 * @param userName
	 * @param userPhoneNumber
	 * @param userAddress
	 * @return
	 */

	@PostMapping(value = "/saveuser")
	public long updateUserAndTicketTable(@RequestParam String userName, @RequestParam String userPhoneNumber,
			@RequestParam String userAddress) {

		Users u = new Users(userName, userPhoneNumber, userAddress);
		/**
		 * checks weather userPhoneNumberAlready exists in database r
		 */
		Optional<Users> usersOptional = serviceLayer.findUsersByUserPhoneNumber(u.getUserPhoneNumber());

		/**
		 * checks validity on userPhoneNumber. Phone number should be of 10 digits 0-9
		 */
		boolean numberCheck = Pattern.matches("[0-9]+", u.getUserPhoneNumber());
		/**
		 * checks validity of userName user name should contain on letters of Alphabet
		 * and spaces
		 */
		boolean nameCheck = Pattern.matches("[a-zA-Z\\s]+", u.getUserName());
		/**
		 * checks validity of userAddress. userAddress should contain letters a-z A-Z
		 * 0-9 . - , : / ( ) and spaces only
		 */
		boolean addressCheck = Pattern.matches("[A-Za-z0-9'\\.\\:\\(\\)\\/\\-\\s\\,]+", u.getUserAddress());

		/**
		 * userPhoneNumber should not registered earlier. If it is error 400 returned
		 */
		if (usersOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Number already Registered. Use a different number");
		}

		/**
		 * if phone number's length is not equal to 10 then it returns error 400 along
		 * with message
		 */
		if (u.getUserPhoneNumber().length() != 10) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number should be of 10 digits");
		}
		if (u.getUserPhoneNumber().charAt(0) < '6') {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Enter a valid phone number. Phone number should start with a digit greater than or equal to 6");
		}
		/**
		 * if user has entered an phone number which contains characters other than 0-9
		 * then it returns error 400 along with message
		 */
		if (numberCheck == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number should contain digits 0-9 only");
		}

		/**
		 * if name contains more characters than 25 then it returns error 400 along with
		 * message
		 */
		if (u.getUserName().length() > 25) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Name should be less than 25 characters");
		}
		/**
		 * if name contains less than 1 character then it returns error 400 along with
		 * message
		 */
		if (u.getUserName().length() < 2) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Name should be greater than or equal to 2 character");
		}
		/**
		 * if user has entered an invalid name then it returns error 400 along with
		 * message
		 */
		if (nameCheck == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Name should contain letters a-z , A-Z and spaces only");
		}

		/**
		 * if address has more than 100 character then it returns error 400 along with
		 * message
		 */
		if (u.getUserAddress().length() > 100) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Address should be less than 100 characters");
		}

		/**
		 * if address has more than 100 character then it returns error 400 along with
		 * message
		 */
		if (u.getUserAddress().length() < 3) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Address should be greater than or equal to 3 characters");
		}

		/**
		 * if address has some invalid characters then it returns error 400 along with
		 * message
		 */
		if (addressCheck == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Address should contain letters a-z A-Z 0-9 . - , : / ( ) and spaces only");
		}
		/**
		 * If all the validations pass , we call addNewUser method of service layer
		 */
		return serviceLayer.addNewUser(u);
	}

}
