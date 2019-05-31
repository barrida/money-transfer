package com.money.dao.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.money.dao.AccountDAO;
import com.money.model.Account;

public class AccountDaoImpl implements AccountDAO {

	private static Map<Integer, Account> accounts = new HashMap<Integer, Account>();

	static {
		accounts.put(0,
				new Account(0, "User1", 111222333, 441200, new BigDecimal(3000).setScale(4, RoundingMode.HALF_EVEN),"TRY"));
		accounts.put(1,
				new Account(1, "User2", 345234123, 896767, new BigDecimal(1400).setScale(4, RoundingMode.HALF_EVEN), "EUR"));
		accounts.put(2,
				new Account(2, "User3", 111222333, 121212, new BigDecimal(122).setScale(4, RoundingMode.HALF_EVEN),"GBP"));
		accounts.put(3,
				new Account(3, "User4", 111222333, 112211, new BigDecimal(0).setScale(4, RoundingMode.HALF_EVEN),"USD"));
		accounts.put(4,
				new Account(4, "Company1", 14231423, 113355, new BigDecimal(0).setScale(4, RoundingMode.HALF_EVEN),"TRY"));
		accounts.put(5,
				new Account(4, "Company2", 9999999, 112200, new BigDecimal(0).setScale(4, RoundingMode.HALF_EVEN),"TRY"));
	}

	public Account getAccountById(int id) {
		return accounts.get(id);
	}

	public List<Account> getAllAccounts() {
		List<Account> result = new ArrayList<Account>();
		for (Integer key : accounts.keySet()) {
			result.add(accounts.get(key));
		}
		return result;
	}

	public int getTotalAccountSize() {
		return accounts.size();
	}

	public void removeAccount() {
		if (!accounts.keySet().isEmpty()) {
			accounts.remove(accounts.keySet().toArray()[0]);
		}
	}

	public String saveAccount(Account account) {
		String result = "";
		if (accounts.get(account.getAccountId()) != null) {
			result = "Updated Account with id=" + account.getAccountId();
		} else {
			result = "Added Account with id=" + account.getAccountId();
		}
		accounts.put(account.getAccountId(), account);
		return result;
	}

}
