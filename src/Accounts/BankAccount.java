package Accounts;

import java.io.Serializable;
import java.util.ArrayList;

import Hardware.Bank;
import People.Customer;
import Hardware.*
;public class BankAccount  implements Serializable {

	//Fields
	protected int accountNumber;
	protected ArrayList<CheckingAccountMonthlyStatement> monthlyStatements;
	protected ArrayList<Transaction> transactions;
	protected Customer owner;
	protected boolean visible; //needs to be false until valid
	protected Bank holdingBank;
	protected double balance;
	//Constructors
	public BankAccount(Bank bank) {
		holdingBank = bank;
		accountNumber = holdingBank.getCurrentAccountNum();
		monthlyStatements = new ArrayList<CheckingAccountMonthlyStatement>();
		transactions = new ArrayList<Transaction>();
		setVisible(false);
	}	
	public void addMonthlyStatement(CheckingAccountMonthlyStatement mS){
		monthlyStatements.add(mS);
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public ArrayList<CheckingAccountMonthlyStatement> getMonthlyStatements() {
		return monthlyStatements;
	}
	public void setMonthlyStatements(ArrayList<CheckingAccountMonthlyStatement> monthlyStatements) {
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
