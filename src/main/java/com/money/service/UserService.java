package com.money.service;

import com.codahale.metrics.annotation.Timed;
import com.money.dao.impl.UserDaoImpl;
import com.money.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")

public class UserService {
	
	UserDaoImpl userDao = new UserDaoImpl();

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Timed
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id) {
		return userDao.getUserById(id);
	}

	@GET
	@Timed
	@Path("/remove")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeUser() {
		userDao.removeUser();
		return "Last user remove. Total count: " + userDao.getTotalUserSize();
	}

	@GET
	@Timed
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}

	@POST
	@Timed
	@Path("/save")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({ MediaType.APPLICATION_JSON })
	public String saveUser(User user) {
		return userDao.updateUser(user);
	}

}
