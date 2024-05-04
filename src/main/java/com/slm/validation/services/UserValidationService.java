package com.slm.validation.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slm.dao.interfaces.IUserDAO;
import com.slm.entities.User;
import com.slm.exceptions.UserAlreadyExistsException;
import com.slm.exceptions.UserNotFoundException;

@Service
public class UserValidationService {

	@Autowired
	IUserDAO iUserDAO;

	public void validateNewUserName(User user) throws UserAlreadyExistsException {

		User fetchedUser = iUserDAO.retrieveUser(user.getUsername());
		if (!Objects.isNull(fetchedUser)) {
			throw new UserAlreadyExistsException();
		}
	}

	public void validateRetrievedUser(User user) throws UserNotFoundException {
		
		if(Objects.isNull(user))
			throw new UserNotFoundException("BUSINESS EXCEPTION");
	}

}
