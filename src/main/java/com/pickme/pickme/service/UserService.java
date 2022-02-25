package com.pickme.pickme.service;

import java.util.List;

import com.pickme.pickme.model.User;

public interface UserService {

	/**
	 *  save user information */
	User saveUser(User user) throws Exception;

	/**
	 * get all users
	 **/
	List<User> getAllUsers();

	/**
	 * update user information
	 */
	User updateUserInfo(User user,Long userId);

	/**
	 * purge user from the system
	 */
	void purgeUserById(Long userId);
}
