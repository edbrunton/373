package Accounts;

import java.io.Serializable;

public class CreditCard extends BankAccount  implements Serializable{

	//Fields
	private double interestRate;
	private double balance;
	private double limit;
	
	//Constructors
	public CreditCard() {
		interestRate = 0;
		balance = 0;
		limit = 0;
	}
	public CreditCard(double iR, double b, double l) {
		interestRate = iR;
		balance = b;
		limit = l;
	}
	
	
	
	
	//Methods
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	
	
	
	
	
}
