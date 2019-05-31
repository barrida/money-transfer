package com.money.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.money.dao.UserDAO;
import com.money.model.User;

public class UserDaoImpl implements UserDAO {

	private static Map<Integer, User> users = new HashMap<Integer, User>();

	static {
		users.put(0, new User(0, "Suleyman", "Yildirim", "12-02-1982", "077878986", "UK", "NE11WW", "Newcastle",
				"user1@gmail.com"));
		users.put(1, new User(3, "Canan", "Yildirim", "12-08-1970", "55567765", "TR", "35456", "Izmir",
				"user2@hotmail.com"));
	}

	public User getUserById(int id) {
		return users.get(id);
	}

	public List<User> getAllUsers() {
		List<User> result = new ArrayList<User>();
		for (Integer key : users.keySet()) {
			result.add(users.get(key));
		}
		return result;
	}

	public int getTotalUserSize() {
		return users.size();
	}

	public void removeUser() {
		if (!users.keySet().isEmpty()) {
			users.remove(users.keySet().toArray()[0]);
		}
	}

	public String saveUser(User user) {
		String result = "";
		if (users.get(user.getUserId()) != null) {
			result = "Updated User with id=" + user.getUserId();
		} else {
			result = "Added User with id=" + user.getUserId();
		}
		users.put(user.getUserId(), user);
		return result;
	}

}
