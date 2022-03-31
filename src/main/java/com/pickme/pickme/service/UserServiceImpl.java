package com.pickme.pickme.service;

import java.util.List;

import com.pickme.pickme.model.User;
import com.pickme.pickme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) throws Exception {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUserInfo(User user, Long userId) {
		User userObject = userRepository.findById(userId).get();
		if (user != null) {
			/** to...do **/
		}
		return null;
	}

	@Override
	public void purgeUserById(Long userId) {
		userRepository.deleteById(userId);
	}
}
