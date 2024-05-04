package com.slm.dao.interfaces;

import org.springframework.stereotype.Component;

import com.slm.entities.User;

@Component
public interface IUserDAO {

	public boolean createUser(User user);

	public User retrieveUser(String username);

	public boolean deleteUser(String username);

	public boolean updateUser(User user);

	public boolean unlockUser(String username);

	public boolean lockUser(String username);

}
