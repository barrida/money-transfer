package com.money.dao;

import java.math.BigDecimal;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

public interface IRate {

	/**
	 * Formats the currency
	 * 
	 * @param currency
	 * @param amount
	 * @param format
	 * @return
	 */
	String formatCurrency(String currency, int amount, Locale format);

	/**
	 * Calculate the current currency rate. Rates are changing on daily basis.
	 * Please check google by the time you test the application
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 * @return
	 */
	BigDecimal calculateRate(String from, String to, BigDecimal amount);

}
