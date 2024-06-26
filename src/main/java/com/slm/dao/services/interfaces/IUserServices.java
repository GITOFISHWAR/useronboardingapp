package com.slm.dao.services.interfaces;

import org.springframework.stereotype.Component;

import com.slm.entities.User;
import com.slm.exceptions.UserAlreadyExistsException;
import com.slm.exceptions.UserNotFoundException;

@Component
public interface IUserServices {

	public void createUser(User user);

	public User retrieveUser(String username);

	public boolean deleteUser(String username) throws UserNotFoundException;

	public boolean updateUser(User user);

	public boolean unlockUser(String username);

	public boolean lockUser(String username) throws UserNotFoundException;

	
}
