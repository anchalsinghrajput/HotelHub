package com.infosys.anchal.UserService.controllers;

import java.util.List;

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

import com.infosys.anchal.UserService.entities.User;
import com.infosys.anchal.UserService.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return new ResponseEntity<>(user1, HttpStatus.CREATED);
	}
	
	//single user
	@GetMapping( "/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//all user
	@GetMapping
	public ResponseEntity<List<User>> getUser(){
		List<User> users = userService.getAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody User user){
		User updatedUser = userService.updateUser(userId, user);
		if(updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		}
		String message = "User with id "+userId+" not found";
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId){
		boolean deleted = userService.deleteUser(userId);
		if(deleted) {
			String message = "User with id "+userId+" is successfully deleted";
			return new ResponseEntity<>(message, HttpStatus.OK);

		}
		String message = "User with id "+userId+" not found";
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
}
