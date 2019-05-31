package com.money.dao;

import java.util.List;

import com.money.model.User;

public interface UserDAO {
	
	//get user by id
	User getUserById(int id);

	//get all users
	List<User> getAllUsers();

	//get the total amount of users
	int getTotalUserSize();

	//removes the first user in user list
	void removeUser();
	
	//removes user by index value
	void removeUserByIndex(int userIndex);

	//add new user or update existing one
	String saveUser(User user);
}
