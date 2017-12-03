package Accounts;
//objects used: Transaction, Fee, Customer,  Bank

import java.io.Serializable;
import java.util.ArrayList;

import Hardware.Bank;
import People.Customer;
import Hardware.*
;public class BankAccount  implements Serializable {

	//Fields
	protected int accountNumber;
	protected ArrayList<Transaction> transactions;
	protected ArrayList<Fee> fees;
	protected Customer owner;
	protected boolean visible; //needs to be false until valid
	protected Bank holdingBank;
	protected double balance;

	//Constructors
	public BankAccount(Bank bank) {
		holdingBank = bank;
		accountNumber = holdingBank.getCurrentAccountNum();
		holdingBank.setCurrentAccountNum(accountNumber + 1);
		transactions = new ArrayList<Transaction>();
		setVisible(false);
		bank.getBankAccounts().add(this);
		this.fees = new ArrayList<Fee>();
		owner = new Customer(holdingBank, "Jeff", "Jeffries", "ss", "Candy Cane Lane", accountNumber, new Date(), accountNumber, new UserLogin());
	}	

	public void addFee(Fee newFee) {
		this.fees.add(newFee);
		this.balance = this.balance - newFee.getAmount();
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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
	public ArrayList<Fee> getFees() {
		return this.fees;
	}
	public void setFees(ArrayList<Fee> fees) {
		this.fees = fees;
	}
	public void setHoldingBank(Bank b) {
		this.holdingBank = b;
	}
	public Bank getHoldingBank() {
		return this.holdingBank;
	}
}
