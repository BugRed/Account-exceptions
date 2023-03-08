package model.entities;

import model.exceptions.WithdrawException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		
		validateWithdraw(amount);
		
		balance -= amount;
	}
	
	private void validateWithdraw(double amount) {
	
		if (amount > getWithdrawLimit()){
			
			throw new WithdrawException("The amount exceeds withdraw limit");
		}
		if (balance <  getBalance()) {
			
			throw new  WithdrawException("Not enough balance");
			
		} 
	}
}
