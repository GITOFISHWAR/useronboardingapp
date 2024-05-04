package com.slm.dao.impl;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slm.dao.interfaces.IUserDAO;
import com.slm.entities.User;
import com.slm.repositories.IUserRepository;

@Component
public class UserDAOImpl implements IUserDAO {

	@Autowired
	IUserRepository userRepository;

	@Override
	public boolean createUser(User user) {

		if (Objects.nonNull(user)) {
			user.setCreationDate(new Date());
			user.setLastUpdateDate(new Date());
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public User retrieveUser(String username) {

		User user = userRepository.findByUsername(username);
		if (Objects.nonNull(user))
			return user;
		return null;
	}

	@Override
	public boolean deleteUser(String username) {

		User user = userRepository.findByUsername(username);
		if (Objects.nonNull(user)) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {

		User loadedUser = userRepository.findByUsername(user.getUsername());
		if (Objects.nonNull(loadedUser)) {
			user.setLastUpdateDate(new Date());
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean unlockUser(String username) {
		User loadedUser = userRepository.findByUsername(username);
		if (Objects.nonNull(loadedUser)) {
			loadedUser.setLocked(false);
			userRepository.save(loadedUser);
			return true;
		}
		return false;
	}

	@Override
	public boolean lockUser(String username) {

		User loadedUser = userRepository.findByUsername(username);
		if (Objects.nonNull(loadedUser)) {
			loadedUser.setLocked(true);
			userRepository.save(loadedUser);
			return true;
		}
		return false;
	}

}
