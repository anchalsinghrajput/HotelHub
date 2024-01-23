package com.infosys.anchal.UserService.services;

import java.util.List;

import com.infosys.anchal.UserService.entities.User;

public interface UserService {

	//create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get a user by it's userId
	User getUser(String userId);
	
	//update user
	User updateUser(String userId, User user);
	
	//delete user
	boolean deleteUser(String userId);
}
