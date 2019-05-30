package com.money.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import com.money.dao.ITransfer;
import com.money.model.Account;

public class TransferMoney implements ITransfer {

	final Rate rate = new Rate();
	int result = -1;

	public int transferMoney(Account sender, Account receiver, BigDecimal amount) throws Exception {

		try {
			if (sender.getBalance().intValueExact() < 0) {
				return result;

			} else {
				// get current rate
				BigDecimal curentRate = rate.calculateRate(sender.getCurrency(), receiver.getCurrency(), amount);

				// add the balance to receiver
				BigDecimal newReceiverBalance = curentRate.add(receiver.getBalance());
				receiver.setBalance(newReceiverBalance);

				// subtract the balance from sender
				BigDecimal newSenderBalance = sender.getBalance().subtract(amount);
				sender.setBalance(newSenderBalance);
				
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
