package Accounts;

import java.io.Serializable;

import Hardware.Bank;

public class CreditCard extends BankAccount  implements Serializable{

	//Fields
	private double interestRate;
	private double limit;
	private double minMonthlyPayment;
	private CheckingAccount C1;
	//Constructors
	public CreditCard(Bank bank) {
		super(bank);
		interestRate = 0;
		balance = 0;
		limit = 0;
		C1 = new CheckingAccount(bank);
	}
	public CreditCard(Bank bank, double iR, double b, double l, CheckingAccount CA) {
		super(bank);
		interestRate = iR;
		balance = b;
		limit = l;
		C1 = CA;
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
	public void purchase(double spent) {
		balance = balance + spent;
		super.holdingBank.getBanksBankAccount().setBalance(super.holdingBank.getBanksBankAccount().getBalance() - spent);
	}
	public void monthlyPayment() {
		minMonthlyPayment = (balance*interestRate) + (0.01*balance);
		balance = balance - minMonthlyPayment;
		C1.withdraw(minMonthlyPayment);
		super.holdingBank.getBanksBankAccount().setBalance(super.holdingBank.getBanksBankAccount().getBalance() + minMonthlyPayment);

	}
	
	
	
	
}
