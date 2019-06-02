package com.money.dao.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;

import com.money.dao.IRate;

public class Rate implements IRate {

	public String formatCurrency(String currency, int amount, Locale locale) {
		MonetaryAmount amountFrom = Monetary.getDefaultAmountFactory().setCurrency(currency).setNumber(amount).create();
		MonetaryAmountFormat amountFormat = MonetaryFormats.getAmountFormat(locale);
		return amountFormat.format(amountFrom);
	}

	public BigDecimal calculateRate(String from, String to, BigDecimal amount) {
		
		CurrencyUnit BRL = Monetary.getCurrency(from);
		CurrencyConversion conversion = MonetaryConversions.getConversion(to);
		Money money = Money.of(amount, BRL).with(conversion);
		BigDecimal rate = new BigDecimal(money.getNumber().toString()).setScale(1, RoundingMode.HALF_EVEN);
		
//		CurrencyUnit currencyFrom = Monetary.getCurrency(from);
//		MonetaryAmount amountFrom = Monetary.getDefaultAmountFactory().setCurrency(currencyFrom).setNumber(amount.intValue()).create();
//		CurrencyConversion amountTo = MonetaryConversions.getConversion(to);
//		MonetaryAmount convertedAmount = amountFrom.with(amountTo);
//		BigDecimal rate = new BigDecimal(convertedAmount.getNumber().toString()).setScale(1, RoundingMode.HALF_EVEN);
		return rate;
	}

}
