package Accounts;

import java.io.Serializable;

import Hardware.Bank;

public class CheckingAccount extends BankAccount  implements Serializable{

	//Fields
	private double balance;
	private double directDeposit;
	
	
	//Constructors
	public CheckingAccount(Bank bank) {
		super(bank);
		balance = 0;
	}
	public CheckingAccount(Bank bank, double b, double dD) {
		super(bank);
		balance = b;
		directDeposit = dD;
	}
	
	
	
	
	
	
	//Methods
	public void Deposit(double d) {
		balance = balance + d;
		super.getTransactions().add(new Transaction(d, "Deposit"));

	}
	public void directDeposit() {
		balance = balance + directDeposit;
		super.getTransactions().add(new Transaction(directDeposit, "Direct Deposit"));
		
	}
	public void withdraw(double w) {
		balance = balance - w;
		super.getTransactions().add(new Transaction(w, "Withdraw"));

	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDirectDeposit() {
		return directDeposit;
	}
	public void setDirectDeposit(double directDeposit) {
		this.directDeposit = directDeposit;
	}
	
	
	
}
