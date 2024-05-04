package com.slm.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slm.dao.interfaces.IUserDAO;
import com.slm.dao.services.interfaces.IUserServices;
import com.slm.entities.User;
import com.slm.exceptions.UserAlreadyExistsException;
import com.slm.exceptions.UserNotFoundException;
import com.slm.validation.services.UserValidationService;

@Service
public class UserApplicationService implements IUserServices {

	@Autowired
	IUserDAO iUserDAO;

	@Autowired
	UserValidationService userValidationService;

	@Override
	public void createUser(User user) {

		try {
			userValidationService.validateNewUserName(user);
			if (iUserDAO.createUser(user)) {
				//
			}
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public User retrieveUser(String username) {

		User user = iUserDAO.retrieveUser(username);
		try {
			userValidationService.validateRetrievedUser(user);
		} catch (UserNotFoundException e) {

			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlockUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
