package com.pickme.pickme.controller;

import java.util.List;

import com.pickme.pickme.Constants;
import com.pickme.pickme.model.User;
import com.pickme.pickme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.REST_V1)
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) throws Exception {
		return userService.saveUser(user);
	}

	@PutMapping(path = "/users/{id}")
	public User updateUserInfo(@RequestBody User user, @PathVariable("id") Long userId) {
		return userService.updateUserInfo(user, userId);
	}

	@DeleteMapping(path = "/users/{id}" )
	public void purgeUser(@PathVariable("id") Long userId) {
		userService.purgeUserById(userId);
	}
}
