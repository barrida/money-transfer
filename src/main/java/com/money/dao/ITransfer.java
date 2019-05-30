package com.money.dao;

import java.math.BigDecimal;
import java.util.Locale;

import javax.money.MonetaryAmount;

import com.money.model.Account;

public interface ITransfer {
	
	/**
	 * Transfer money between accounts
	 * @param from
	 * @param to
	 * @param amount
	 * @return 
	 * @throws Exception 
	 */
	int transferMoney(Account from, Account to, BigDecimal amount) throws Exception;
}
