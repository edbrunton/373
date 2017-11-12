package Accounts;

import java.io.Serializable;

public class SavingsAccount extends BankAccount  implements Serializable{

	//Fields
	private double interestRate;
	private double balance;
	private double minBalance;
	
	//Constructors
	public SavingsAccount() {
		setInterestRate(0);
		setBalance(0);
		setMinBalance(0);
	}
	public SavingsAccount(double iR, double b, double mB) {
		setInterestRate(iR);
		setBalance(b);
		setMinBalance(mB);
	}
	
	//Methods
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public void monthlyInterest() {
		balance = balance + (balance * (interestRate/1200));
	}
	
	
	
}
