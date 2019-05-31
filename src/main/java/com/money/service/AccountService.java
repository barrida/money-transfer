package com.money.service;

import com.codahale.metrics.annotation.Timed;
import com.money.dao.impl.AccountDaoImpl;
import com.money.model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/account")

public class AccountService {

    AccountDaoImpl accountDao = new AccountDaoImpl();
	
    public AccountService() {
	}

	@GET
	@Timed
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("id") int id) {
		return accountDao.getAccountById(id);
	}

	@GET
	@Timed
	@Path("/remove")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeAccount() {
		accountDao.removeAccount();
		return "Last account remove. Total count: " + accountDao.getTotalAccountSize();
	}

	@GET
	@Timed
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAccounts() {
		return accountDao.getAllAccounts();
	}

	@POST
	@Timed
	@Path("/save")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({ MediaType.APPLICATION_JSON })
	public String saveAccount(Account account) {
		return accountDao.saveAccount(account);
				
	}

}
