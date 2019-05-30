package com.money.model;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

	private int accountId;
	private String userName;
	private long accountNumber;
	private int sortCode;
	private String currency;
	private BigDecimal balance;
	private String companyName;
	private String iban;
	private String swift;

	public Account() {

	}
	
	/**
	 * 
	 * Personal Account
	 * 
	 * @param accountId
	 * @param userName
	 * @param surname
	 * @param accountNumber
	 * @param sortCode
	 * @param balance
	 */
	public Account(int accountId, String userName, long accountNumber, int sortCode, BigDecimal balance, String currency) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.balance = balance;
		this.currency = currency;
		
	}

	
	/**
	 *  Business Account
	 *  
	 * @param accountId
	 * @param companyName
	 * @param iban
	 * @param swift
	 * @param balance
	 */
	public Account(int accountId, String companyName, String iban, String swift, BigDecimal balance, String currency) {
		super();
		this.accountId = accountId;
		this.companyName = companyName;
		this.iban = iban;
		this.swift = swift;
		this.balance = balance;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userName=" + userName + ", accountNumber=" + accountNumber
				+ ", sortCode=" + sortCode + ", currency=" + currency + ", balance=" + balance + ", companyName="
				+ companyName + ", iban=" + iban + ", swift=" + swift + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		result = prime * result + sortCode;
		result = prime * result + ((swift == null) ? 0 : swift.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		if (sortCode != other.sortCode)
			return false;
		if (swift == null) {
			if (other.swift != null)
				return false;
		} else if (!swift.equals(other.swift))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	

}
