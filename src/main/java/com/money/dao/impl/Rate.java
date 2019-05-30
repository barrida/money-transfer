package com.money.dao.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import com.money.dao.IRate;

public class Rate implements IRate {

	public String formatCurrency(String currency, int amount, Locale locale) {
		MonetaryAmount amountFrom = Monetary.getDefaultAmountFactory().setCurrency(currency).setNumber(amount).create();
		MonetaryAmountFormat amountFormat = MonetaryFormats.getAmountFormat(locale);
		return amountFormat.format(amountFrom);
	}

	public BigDecimal calculateRate(String from, String to, BigDecimal amount) {
		MonetaryAmount amountFrom = Monetary.getDefaultAmountFactory().setCurrency(from).setNumber(amount).create();
		CurrencyConversion amountTo = MonetaryConversions.getConversion(to);
		MonetaryAmount convertedAmount = amountFrom.with(amountTo);
		BigDecimal rate = new BigDecimal(convertedAmount.getNumber().toString()).setScale(4, RoundingMode.HALF_EVEN);
		return rate;
	}

}
