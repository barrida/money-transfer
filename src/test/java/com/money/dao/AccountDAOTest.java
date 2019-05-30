package com.money.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.money.dao.impl.AccountDaoImpl;
import com.money.model.Account;

public class AccountDAOTest {

	AccountDaoImpl accounts;
	
	@Test
	public void testGetAccountById() {
		accounts = new AccountDaoImpl();
		assertNotNull(accounts);
		Account account = accounts.getAccountById(0);
		assertEquals("User1", account.getUserName());
	}

	@Test
	public void testGetAllAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalAccountSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAccount() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSendMoney() {
		fail("Not yet implemented");
	}
	@Test
	public void testReceiveMoney() {
		fail("Not yet implemented");
	}

}
