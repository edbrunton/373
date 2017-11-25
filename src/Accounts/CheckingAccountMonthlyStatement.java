
package Accounts;

import java.io.Serializable;
import java.util.*;
import Accounts.*;
import Hardware.*;
public class CheckingAccountMonthlyStatement  implements Serializable{
/*The Checking Account Monthly statement currently has a StringBuilder for printing to GUI's, an ArrayList of Fees,
   a beginning and ending balance a monthandYear field and an associated checking account*/
	private StringBuilder sb;
	private ArrayList<Fee> fees;
	private double begBalance, endBalance;
	private String monthAndYear;
	private CheckingAccount accnt;

/* lines 17 thru 50 are the getters and setter*/
	public void setBegBalance(double begBal) {
		this.begBalance = begBal;
	}
	public double getBegBalance() {
		return this.begBalance;
	}
	
	public void setFees(ArrayList<Fee> fees) {
		this.fees = fees;
	}
	public ArrayList<Fee> getFee(){
		return this.fees;
	}
	
	public double getEndBalance() {
		return endBalance;
	}
	public void setEndBalance(double endBalance) {
		this.endBalance = endBalance;
	}
	
	public void setAccount(CheckingAccount ca) {
		this.accnt = ca;
	}
	public BankAccount getAccount() {
		return this.accnt;
	}
	public void setMonthAndYear(String monthAndYear) {
		this.monthAndYear = monthAndYear;
	}
	public String getMonthAndYear() {
		return this.monthAndYear;
	}
	
	/* this function is the no arg constructor. */
	public CheckingAccountMonthlyStatement() {  
		this.begBalance = 0;
		this.endBalance = 0;
		this.monthAndYear = "January 2018";
		Bank b1 = new Bank();
		this.accnt = new CheckingAccount(b1);
		this.fees = new ArrayList<Fee>();
		this.sb = new StringBuilder();
		
	}
	/* This function is the parametered constructor. It takes in the date and the account.*/
	public CheckingAccountMonthlyStatement(String monthAndYear, CheckingAccount ca) { 
		this.accnt = ca; 
		this.sb = new StringBuilder();
		this.fees = new ArrayList<Fee>();
		this.calcBegBal(ca);
		this.endBalance = ca.getBalance();
		this.monthAndYear = monthAndYear;
		
		 
		
	}
	/*this function calculates beginning balance by negating transactions which have directly modified balance already(used in constructor)*/	
	public void calcBegBal(CheckingAccount ca) { 
		this.begBalance = accnt.getBalance();
			for(Transaction t : ca.getTransactions()) {
				if(t.getType()== "Deposit") {
					this.begBalance = this.begBalance - t.getAmmount();
				}
				if(t.getType()== "Direct Deposit") {
					this.begBalance = this.begBalance - t.getAmmount();
				}
				if(t.getType() == "Withdraw") {
					this.begBalance = this.begBalance + t.getAmmount();
				}
			}
		}
		
	
	
/*this function adds a fee to the fee arrayList and updates the ending balance accordingly*/	
	public void addFee(Fee newFee) {
		this.fees.add(newFee);
		this.endBalance = this.endBalance - newFee.getAmount();
		
	}
	
	
  /* this function is useful if we only want to print fees*/  
	public void printFees() {
	
	sb.append("Fees for: "+monthAndYear+"\n");
	for(Fee f: fees) {
    sb.append(f.getAmount()+" "+f.getType()+"\n");	
    }
	System.out.print(sb);
	sb.setLength(0);// clears the StringBuilder to avoid printing unwanted stuff

	}
/* this function is useful if we only want to print transactions*/  	
	public void printTransactions() {
		sb.append("Transaction for: " +monthAndYear+"\n");
		for(Transaction t : this.accnt.getTransactions()) {
			sb.append(t+"\n");
			
			
		}
		System.out.print(sb);
		sb.setLength(0);//Clears the StringBuilder to avoid printing unwanted stuffs

	}
	
/*	public void printInterest() {
		if(this.accnt instanceof SavingsAccount ) {
			SavingsAccount sa = (SavingsAccount)this.accnt;
			sb.append("Interest gained for: "+monthAndYear+"\n");
			sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
			System.out.print(sb);
			sb.setLength(0); // Clears StringBuilder to avoid printing unwanted stuff
			
			
			
		}
	}*/
	

        		
        
 /* this function is useful if we only want to print beginning and ending balances*/        
	public void printBegEndBal() {
		sb.append("Starting Balance for " +monthAndYear+": "+begBalance+ "\n");
		sb.append("Ending Balance for "+monthAndYear+": "+endBalance+"\n");
		System.out.print(sb);
		sb.setLength(0);
		
	}
	
	public void printMonthlyStatement() { // prints start , end balance, transactions, fees, and interest gained if savings account
		sb.append("Starting Balance for " +monthAndYear+": "+begBalance+ "\n");
		sb.append("Ending Balance for "+monthAndYear+": "+endBalance+"\n");
		sb.append("Fees for: "+monthAndYear+"\n");
		for(Fee f: fees) {
	    sb.append(f.getAmount()+" "+f.getType()+"\n");	
	    
	    }
		sb.append("Transaction for: " +monthAndYear+"\n");
		for(Transaction t : this.accnt.getTransactions()) {
			sb.append(t.getAmmount()+" "+t.getType()+"\n");
			}
		System.out.print(sb);
		/*if(this.accnt instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount)this.accnt;
			sb.append("Interest gained for: "+monthAndYear+"\n");
			sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
			}*/
		
	}
}
