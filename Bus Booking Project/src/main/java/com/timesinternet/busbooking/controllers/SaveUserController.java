package com.timesinternet.busbooking.controllers;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.timesinternet.busbooking.entities.Users;
import com.timesinternet.busbooking.repositories.UsersRepository;
import com.timesinternet.busbooking.services.ServiceLayer;

@RestController
public class SaveUserController {
	private final UsersRepository usersRepository;
	private final ServiceLayer serviceLayer;

	@Autowired
	public SaveUserController(UsersRepository usersRepository, ServiceLayer serviceLayer) {
		this.usersRepository = usersRepository;
		this.serviceLayer = serviceLayer;
	}

	@PostMapping(value = "/saveuser")
	public long updateUserAndTicketTable(@RequestParam String userName, @RequestParam String userPhoneNumber,
			@RequestParam String userAddress) {

		Users u = new Users(userName, userPhoneNumber, userAddress);

		Optional<Users> usersOptional = usersRepository.findUsersByUserPhoneNumber(u.getUserPhoneNumber());

		boolean numberCheck = Pattern.matches("[0-9]+", u.getUserPhoneNumber());

		boolean nameCheck = Pattern.matches("[a-zA-Z\\s]+", u.getUserName());

		if (usersOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Number already Registered. Use a different number");
		}

		if (nameCheck == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Name should contain letters a-z , A-Z and spaces only");
		}

		if (numberCheck == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User number should contain digits 0-9 only");
		}
		if (u.getUserPhoneNumber().length() != 10) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User number should be of 10 digits");
		}

		if (u.getUserName().length() > 25) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Name should be less than 25 characters");
		}
		if (u.getUserAddress().length() > 100) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Address should be less than 100 characters");
		}

		return serviceLayer.addNewUser(u);
	}

}
