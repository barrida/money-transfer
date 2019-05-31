package com.money.dao;

import java.util.List;

import com.money.model.User;

public interface UserDAO {
	User getUserById(int id);

	List<User> getAllUsers();

	int getTotalUserSize();

	void removeUser();

	String saveUser(User user);
}
