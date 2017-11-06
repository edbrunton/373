package Accounts;

import java.io.Serializable;

public class CheckingAccount extends BankAccount  implements Serializable{

	//Fields
	private double balance;
	
	
	//Constructors
	public CheckingAccount() {
		balance = 0;
	}
	public CheckingAccount(double b) {
		balance = b;
	}
	
	
	
	
	
	
	//Methods
	public void directDeposit(double d) {
		balance = balance + d;
		super.getTransactions().add(new Transaction(d, "Direct Deposit"));
		
	}
	public void withdraw(double w) {
		balance = balance - w;
		super.getTransactions().add(new Transaction(-w, "Withdraw"));

	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
