package Accounts;

import java.io.Serializable;

import Hardware.Bank;

public class SavingsAccount extends BankAccount  implements Serializable{

	//Fields
	private double interestRate;
	private double minBalance;
	
	//Constructors
	public SavingsAccount(Bank bank) {
		super(bank);
		setInterestRate(0);
		setBalance(0);
		setMinBalance(0);
	}
	public SavingsAccount(Bank bank, double iR, double b, double mB) {
		super(bank);
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
		super.holdingBank.getBanksBankAccount().setBalance(super.holdingBank.getBanksBankAccount().getBalance() - (balance * (interestRate/1200)));
	}
	
	
	
}
