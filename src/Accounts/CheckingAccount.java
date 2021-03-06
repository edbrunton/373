package Accounts;

import java.io.Serializable;
import java.util.ArrayList;

import Hardware.Bank;
import MonthlyStatement.CheckingAccountMonthlyStatement;
import Hardware.*;
public class CheckingAccount extends BankAccount  implements Serializable{

	//Fields
	private double directDeposit;//TODO Ryan: he is 100% in charge of this
	protected ArrayList<CheckingAccountMonthlyStatement> monthlyStatements;
	
	//Constructors
	public CheckingAccount(Bank bank) {
		super(bank);
		balance = 0;
		monthlyStatements =new ArrayList<CheckingAccountMonthlyStatement>();
		System.out.println("If this is printing, mortage made a checking acocunt");
	}
	public CheckingAccount(Bank bank, double b, double dD) {
		super(bank);
		balance = b;
		System.out.println("Checking account has initial balance of " + b);
		directDeposit = dD;
		monthlyStatements =new ArrayList<CheckingAccountMonthlyStatement>();
	}
	
	
	
	
	
	
	//Methods
	
	public void addMonthlyStatement(CheckingAccountMonthlyStatement mS){
		if(this.monthlyStatements == null) {
			this.setMonthlyStatements(new ArrayList<CheckingAccountMonthlyStatement>());
		}
		monthlyStatements.add(mS);
	}
	public void Deposit(double d) {
		balance = balance + d;
		super.getTransactions().add(new Transaction(d, "Deposit"));

	}
	public void directDeposit() {//this is a monthly function
		balance = balance + directDeposit;
		super.getTransactions().add(new Transaction(directDeposit, "Direct Deposit"));
		CheckingAccountMonthlyStatement cams = new CheckingAccountMonthlyStatement(this);
		this.addMonthlyStatement(cams);
		this.transactions.clear();
		this.fees.clear();
		
		
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
	public void setMonthlyStatements(ArrayList<CheckingAccountMonthlyStatement> mS) {
		this.monthlyStatements = mS;
		
	}
	public ArrayList<CheckingAccountMonthlyStatement> getMonthlyStatements() {
		return this.monthlyStatements;
	}
	
	
}
