package com.slm.exceptions.controlleradvise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.slm.exceptions.UserAlreadyExistsException;
import com.slm.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException userNotFoundException) {

		return new ResponseEntity<>(userNotFoundException.getMessage() + " User Not Found!!!",
				HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> userAlreadyExistException(UserAlreadyExistsException userAlreadyExistsException) {

		return new ResponseEntity<>(
				userAlreadyExistsException.getMessage()
						+ "Username alreay Exists. Kindly try with a different username",
				HttpStatus.EXPECTATION_FAILED);
	}
}
