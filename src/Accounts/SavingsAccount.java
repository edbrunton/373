package Accounts;

import java.io.Serializable;
import java.util.ArrayList;

import Hardware.Bank;
import MonthlyStatement.SavingsAccountMonthlyStatement;

public class SavingsAccount extends BankAccount  implements Serializable{

	//Fields
	private double interestRate;
	private double minBalance;
	protected ArrayList<SavingsAccountMonthlyStatement> monthlyStatements;

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
	public void addMonthlyStatement(SavingsAccountMonthlyStatement mS){
		monthlyStatements.add(mS);
	}
	public void setMonthlyStatements(ArrayList<SavingsAccountMonthlyStatement> mS) {
		this.monthlyStatements = mS;
	}
	public ArrayList<SavingsAccountMonthlyStatement> getMonthlyStatements() {
		return this.monthlyStatements;
	}
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
	public void monthlyInterest() {// add to transaction, this is monthly function
		balance = balance + (balance * (interestRate/1200));
		super.holdingBank.getBanksBankAccount().setBalance(super.holdingBank.getBanksBankAccount().getBalance() - (balance * (interestRate/1200)));
	}
	
	
	
}
