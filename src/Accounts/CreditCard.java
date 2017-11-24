package Accounts;

import java.io.Serializable;

import Hardware.Bank;

public class CreditCard extends BankAccount  implements Serializable{

	//Fields
	private double interestRate;
	private double limit;
	
	//Constructors
	public CreditCard(Bank bank) {
		super(bank);
		interestRate = 0;
		balance = 0;
		limit = 0;
	}
	public CreditCard(Bank bank, double iR, double b, double l) {
		super(bank);
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
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	
}
