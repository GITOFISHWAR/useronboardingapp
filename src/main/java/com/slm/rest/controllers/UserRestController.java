package com.slm.rest.controllers;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slm.dao.services.interfaces.IUserServices;
import com.slm.entities.User;
import com.slm.exceptions.UserAlreadyExistsException;
import com.slm.exceptions.UserNotFoundException;
import com.slm.validation.services.UserValidationService;

@RestController
public class UserRestController {

	@Autowired
	IUserServices userServices;

	Date date = new Date();

	@Autowired
	UserValidationService userValidationService;

	private static final String USER_ALREADY_EXISTS_EXEPTION = "USER_ALREADY_EXISTS_EXEPTION";

	@GetMapping(value = "/fetchuser/{username}")
	public ResponseEntity<User> fetchUser(@PathVariable("username") String username) throws UserNotFoundException {

		User user = null;
		try {
			user = userServices.retrieveUser(username);
			if (!Objects.nonNull(user)) {

				throw new UserNotFoundException(date.toString() + username);
			}
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new UserNotFoundException(date.toString() + username);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/createuser")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		try {
			userValidationService.validateNewUserName(user);
			userServices.createUser(user);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e + " Failed " + USER_ALREADY_EXISTS_EXEPTION, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Object>(user.getUsername() + " Created Successfully", HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteuser/{username}")
	public ResponseEntity<Object> deleteUser(@PathVariable String username) {

		try {
			userServices.deleteUser(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e + " Failed", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Object>(username + " Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping(value = "/lockuser/{username}")
	public ResponseEntity<Object> lockUser(@PathVariable String username) {
		try {
			userServices.lockUser(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e + " Failed", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Object>(username + " Locked!!!", HttpStatus.OK);
	}
}
