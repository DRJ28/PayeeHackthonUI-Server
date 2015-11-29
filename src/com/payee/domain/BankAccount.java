package com.payee.domain;

public class BankAccount {

	private String countryName;
	private String bankName;
	private String accountNumber;
	private String bankCode;
	private String accountName;
	private String bankId;
	private String userId;
	private boolean valid = false;
	
	public String getCountryName() {
		return countryName;
	}
	public boolean getValid() {
		return valid;
	}
	public void setValid(boolean b) {
		this.valid = b;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
