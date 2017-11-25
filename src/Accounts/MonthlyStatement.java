
package Accounts;

import java.io.Serializable;
import java.util.*;
import Accounts.*;
import Fees.*;
import Hardware.*;
public class MonthlyStatement  implements Serializable{

	private StringBuilder sb = new StringBuilder();
	private ArrayList<Fee> fees;
	private double begBalance, endBalance;
	private String monthAndYear;
	private BankAccount accnt;
	
	public MonthlyStatement() {
		this.begBalance = 0;
		this.endBalance = 0;
		this.monthAndYear = "January 2018";
		this.accnt = null;
		this.setFees(null);
		this.sb = null;
		
	}
	public MonthlyStatement(String monthAndYear, BankAccount accnt) {
		this.sb = null;
		this.fees = null;
		this.begBalance = accnt.getBalance();
		if(accnt instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount)accnt;
	this.begBalance = sa.getBalance() -(sa.getBalance() * (sa.getInterestRate()/1200));
		}
		
		if(accnt instanceof CheckingAccount) {
			CheckingAccount ca = (CheckingAccount)accnt;
			
		
		for(Transaction t : ca.getTransactions()) {
			if(t.getType()== "Deposit") {
			this.begBalance = this.begBalance - t.getAmmount();
			}
			if(t.getType()== "Direct Deposit") {
				this.begBalance = this.begBalance - t.getAmmount();
				}
			if(t.getType() == "withdraw") {
				this.begBalance = this.begBalance + t.getAmmount();
			}
		}
		}
		
		this.monthAndYear = monthAndYear;
		if(accnt instanceof CheckingAccount) {
		CheckingAccount ca = (CheckingAccount)accnt;
		this.accnt = ca;
		}
		if(accnt instanceof CreditCard) {
			CreditCard cc = (CreditCard)accnt;
			this.accnt = cc;
			}
		if(accnt instanceof Mortgage) {
			Mortgage m = (Mortgage)accnt;
			this.accnt = m;
			}
		if(accnt instanceof SavingsAccount) {
			SavingsAccount ca = (SavingsAccount)accnt;
			this.accnt = ca;
			}
		this.endBalance = 0;
	}
	public void addFee(Fee newFee) {// can it discern different fees?
		if(newFee instanceof LateFee) {
		    LateFee lf = (LateFee)newFee;
			this.fees.add(lf);
		}
		if(newFee instanceof LowBalanceFee) {
			LowBalanceFee lbf = (LowBalanceFee)newFee;
			this.fees.add(lbf);
		}
		if(newFee instanceof TransferFee) {
			TransferFee tf = (TransferFee)newFee;
			this.fees.add(tf);
		}
	}
	
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
	
	public void setAccount(BankAccount accnt) {
		this.accnt = accnt;
	}
	public BankAccount getAccount() {
		return this.accnt;
	}
    
	public void printFees() {//if we only want to print fees
	
	sb.append("Fees for: "+monthAndYear+"\n");
	for(Fee f: fees) {
    sb.append(f+"\n");	
    }
	System.out.print(sb);
	sb.setLength(0);// clears the StringBuilder to avoid printing unwanted stuff

	}
	
	public void printTransactions() {// if we only want to print transactions
		sb.append("Transaction for: " +monthAndYear+"\n");
		for(Transaction t : this.accnt.getTransactions()) {
			sb.append(t+"\n");
			
			
		}
		System.out.print(sb);
		sb.setLength(0);//Clears the StringBuilder to avoid printing unwanted stuffs

	}
	
	public void printInterest() {
		if(this.accnt instanceof SavingsAccount ) {
			SavingsAccount sa = (SavingsAccount)this.accnt;
			sb.append("Interest gained for: "+monthAndYear+"\n");
			sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
			System.out.print(sb);
			sb.setLength(0); // Clears StringBuilder to avoid printing unwanted stuff
			
			
			
		}
	}
	
	public double calcEndBal() {// subtract amounts or add? 
		endBalance = this.begBalance;
        for(Transaction t :this.accnt.getTransactions()) {
        	endBalance = endBalance - t.getAmmount();
        }
        	for(Fee f : this.fees) {
        		if(f instanceof LateFee) {
        			LateFee lf = (LateFee)f;
        			endBalance = endBalance - lf.getAmount();
        		}
        		if(f instanceof LowBalanceFee) {
        			LowBalanceFee lbf = (LowBalanceFee)f;
        			endBalance = endBalance -lbf.getAmount();
        		}
        		if(f instanceof TransferFee) {
        			TransferFee tf = (TransferFee)f;
        			endBalance = endBalance -tf.getAmount();
        		}
        }
        if(this.accnt instanceof SavingsAccount) {
        	SavingsAccount sa = (SavingsAccount)this.accnt;
        	endBalance = endBalance +(sa.getBalance() * (sa.getInterestRate()/1200));
        }
        if(this.accnt instanceof CheckingAccount) { // add comment
        	CheckingAccount ca = (CheckingAccount)this.accnt;
        	for(Transaction t : ca.getTransactions()) {
        		if(t.getType()=="Direct Deposit") {
        			endBalance = endBalance +t.getAmmount() ;
        		}
        		if(t.getType()=="Deposit") {
        			endBalance = endBalance +t.getAmmount();
        			}
        		if(t.getType() == "withdraw") {
    				endBalance = endBalance - t.getAmmount();
    			}
        	}
        		
        }
        return endBalance;
	}	
	public void printBegEndBal() {
		this.calcEndBal();
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
	    sb.append(f+"\n");	
	    }
		sb.append("Transaction for: " +monthAndYear+"\n");
		for(Transaction t : this.accnt.getTransactions()) {
			sb.append(t+"\n");
			}
		if(this.accnt instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount)this.accnt;
			sb.append("Interest gained for: "+monthAndYear+"\n");
			sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
			}
		
	
	
	
	//code a print String with transactions and fees
	//if savings account show interest gained
	//show beggining of month and end of month balance
	// include month name and year
	
	
	
	
	
	
}
}
