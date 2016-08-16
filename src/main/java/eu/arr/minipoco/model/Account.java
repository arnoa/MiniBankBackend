package eu.arr.minipoco.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable{

	private static final long serialVersionUID = -987340891382502363L;
	
	private int id;
	private BigDecimal balance;
	private String iban;
	private String name;
	private String currency;
	
	public int getAccountId() {
		return id;
	}
	public void setAccountId(int accountId) {
		this.id = accountId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getIban() {
		return iban;
	}
	public void setIBAN(String iban) {
		this.iban = iban;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
