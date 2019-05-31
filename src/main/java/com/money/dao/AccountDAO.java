package com.money.dao;

import java.math.BigDecimal;
import java.util.List;

import com.money.model.Account;

public interface AccountDAO {

	Account getAccountById(int id);

	List<Account> getAllAccounts();

	int getTotalAccountSize();

	void removeAccount();

	String saveAccount(Account account);

//	/**
//	 * Receive money
//	 * @param account
//	 * @param amount
//	 */
//	void receiveMoney(Account account, BigDecimal amount);
//
//	/**
//	 * 
//	 * @param account
//	 * @param amount
//	 */
//	void sendMoney(Account account, BigDecimal amount);
}
