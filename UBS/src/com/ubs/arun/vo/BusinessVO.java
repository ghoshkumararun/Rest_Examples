package com.ubs.arun.vo;

import java.math.BigDecimal;

public class BusinessVO {

	// CompanyCode, Account, City, Country, CreditRating, Currency, Amount

	private int CompanyCode;
	private int Account;
	private String City;
	private String Country;
	private String CreditRating;
	private String Currency;
	private Double Amount;

	public int getCompanyCode() {
		return CompanyCode;
	}

	public void setCompanyCode(int companyCode) {
		CompanyCode = companyCode;
	}

	public int getAccount() {
		return Account;
	}

	public void setAccount(int account) {
		Account = account;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCreditRating() {
		return CreditRating;
	}

	public void setCreditRating(String creditRating) {
		CreditRating = creditRating;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	// constructors
	public BusinessVO(int CompanyCode, int Account, String City, String Country, String CreditRating, String Currency,
			Double Amount) {
		this.CompanyCode = CompanyCode;
		this.Account = Account;
		this.City = City;
		this.Country = Country;
		this.CreditRating = CreditRating;
		this.Currency = Currency;
		this.Amount = Amount;

	}

}