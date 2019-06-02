package com.money.dao.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.money.model.Account;

public class TransferMoneyTest {

	static TransferMoney money;
	static AccountDaoImpl accounts;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		 money = new TransferMoney();
		 accounts = new AccountDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void testTransferMoney() throws Exception {

		Account sender = accounts.getAccountById(1); // 1400 EUR
		Account receiver = accounts.getAccountById(2); // 122 GBP
		BigDecimal balance = new BigDecimal(100); // 100 EUR = 88.1480  GBP as of today
		money.transferMoney(sender, receiver, balance);
		assertEquals("1400.0000", sender.getBalance().toString()); // 1400 EUR - 100 EUR = 1300
		assertEquals("210.6000", receiver.getBalance().toString()); // 122 GBP + 88.1480 GBP = 210.1480
	}

}
