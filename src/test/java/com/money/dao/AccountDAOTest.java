package com.money.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.http.impl.client.HttpClients;
import org.junit.BeforeClass;
import org.junit.Test;

import com.money.dao.impl.AccountDaoImpl;
import com.money.model.Account;

public class AccountDAOTest {

	static AccountDaoImpl accounts;

	@BeforeClass
	public static void setup() throws Exception {
		accounts = new AccountDaoImpl();
	}

	@Test
	public void testGetAccountById() {
		Account account = accounts.getAccountById(0);
		assertEquals("User1", account.getUserName());
	}

	@Test
	public void testGetAllAccounts() {

		List<Account> account = accounts.getAllAccounts();
		assertNotNull(account);
	}

	@Test
	public void testGetTotalAccountSize() {
		int size = accounts.getTotalAccountSize();
		assertEquals(6, size);
	}

	@Test
	public void testRemoveAccount() {
		accounts.removeAccount();
		assertEquals(5, accounts.getTotalAccountSize());
	}

	@Test
	public void testUpdateAccount() {
		String accountId = accounts
				.saveAccount(new Account(12, "company", "iban", "swift", new BigDecimal(13500000), "GBP"));
		assertEquals("Added Account with id=12", accountId);
		accounts.removeAccount();
		assertEquals(6, accounts.getTotalAccountSize());
	}

}
