package Accounts;

import java.io.Serializable;
import java.util.ArrayList;

import Hardware.Bank;
import People.Customer;

public class BankAccount  implements Serializable {

	//Fields
	private double accountNumber;
	private ArrayList<MonthlyStatement> monthlyStatements;
	private ArrayList<Transaction> transactions;
	private Customer owner;
	private boolean visible; //needs to be false until valid
	private Bank holdingBank;
	//Constructors
	public BankAccount(Bank bank) {
		holdingBank = bank;
		accountNumber = holdingBank.getCurrentAccountNum();
		monthlyStatements = new ArrayList<MonthlyStatement>();
		transactions = new ArrayList<Transaction>();
		setVisible(false);
	}
	
	
	
	
	
	
	
	//Methods
	public void addMonthlyStatement(MonthlyStatement mS){
		monthlyStatements.add(mS);
	}
	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public ArrayList<MonthlyStatement> getMonthlyStatements() {
		return monthlyStatements;
	}
	public void setMonthlyStatements(ArrayList<MonthlyStatement> monthlyStatements) {
		this.monthlyStatements = monthlyStatements;
	}







	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}







	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}







	public Customer getOwner() {
		return owner;
	}







	public void setOwner(Customer owner) {
		this.owner = owner;
	}







	public boolean isVisible() {
		return visible;
	}







	public void setVisible(boolean visible) {
		this.visible = visible;
	}







	
	
	
	
	
}
