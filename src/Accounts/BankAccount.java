package Accounts;

import java.io.Serializable;
import java.util.ArrayList;

public class BankAccount  implements Serializable {

	//Fields
	private int accountNumber;
	private ArrayList<MonthlyStatement> monthlyStatements;
	private ArrayList<Transaction> transactions;
	
	//Constructors
	public BankAccount() {
		accountNumber = -1;
		monthlyStatements = new ArrayList<MonthlyStatement>();
	}
	
	
	
	
	
	
	
	//Methods
	public void addMonthlyStatement(MonthlyStatement mS){
		monthlyStatements.add(mS);
	}
	public int getAccountNumber() {
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







	
	
	
	
	
}
