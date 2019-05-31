package com.money.dao.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import com.money.dao.IRate;
import com.money.dao.impl.Rate;

import junit.framework.TestCase;

public class RateTest extends TestCase {

	public void testFormatCurrency() {
		IRate rate = new Rate();

		String formatGBP = rate.formatCurrency("GBP", 1, Locale.UK);
		assertEquals("GBP1.00", formatGBP);

		String formatCANADA = rate.formatCurrency("GBP", 1, Locale.CANADA);
		assertEquals("GBP1.00", formatCANADA);

		String formatUSD = rate.formatCurrency("USD", 1, Locale.UK);
		assertEquals("USD1.00", formatUSD);

		String formatGERMANY = rate.formatCurrency("USD", 1, Locale.GERMANY);
		assertEquals("1,00 USD", formatGERMANY);

	}

	/*
	 * Rates are changing on daily basis. Please check google by the time you
	 * test the application
	 */
	public void testCalcualteRate() {
		IRate rate = new Rate();

		BigDecimal convertEURtoGBP = rate.calculateRate("EUR", "GBP", new BigDecimal(100));
		assertNotNull(convertEURtoGBP);
		assertEquals("88.1480", convertEURtoGBP.toString());

		BigDecimal convertGBPtoUSD = rate.calculateRate("GBP", "USD", new BigDecimal(1));
		assertNotNull(convertGBPtoUSD);
		assertEquals("1.2631", convertGBPtoUSD.toString());

		BigDecimal convertUSDtoGBP = rate.calculateRate("USD", "GBP", new BigDecimal(1));
		assertNotNull(convertUSDtoGBP);
		assertEquals("0.7917", convertUSDtoGBP.toString());
	}

}
