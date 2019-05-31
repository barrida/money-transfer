package com.money.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.money.dao.impl.AccountDaoImpl;
import com.money.dao.impl.UserDaoImpl;
import com.money.model.Account;
import com.money.model.User;

public class UserDAOTest {

	static UserDaoImpl userDao;

	@BeforeClass
	public static void setup() throws Exception {
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void testGetUserById() {
		User user = userDao.getUserById(0);
		assertEquals("Suleyman", user.getName());
		assertEquals("NE11WW", user.getPostalCode());
		assertEquals("UK", user.getCountry());
		assertEquals("user1@gmail.com", user.getEmail());
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userDao.getAllUsers();
		assertNotNull(users);
		assertTrue(users.size() == 2);
	}

	@Test
	public void testGetTotalUserSize() {
		List<User> users = userDao.getAllUsers();
		assertEquals(3, userDao.getTotalUserSize());
	}

	@Test
	public void testRemoveUser() {
		List<User> users = userDao.getAllUsers();
		//userDao.removeUser();
		//assertEquals(2, userDao.getTotalUserSize());
	}

	@Test
	public void testUpdateUser() {
		User user = new User(0, "Suleyman", "Yildirim", "12-02-1982", "077878986", "UK", "NE11WW", "Newcastle",
				"user1@gmail.com");
		userDao.saveUser(user);
		
		assertTrue(userDao.getTotalUserSize() == 2);

		User user3 = new User(5, "User 3 Name", "User 3 Surnameame", "23-02-1982", "39394005", "UK", "NT67WW", "Birmigham",
				"user3@gmail.com");
		
		userDao.saveUser(user3);

		assertTrue(userDao.getTotalUserSize() == 3);
	}

}
