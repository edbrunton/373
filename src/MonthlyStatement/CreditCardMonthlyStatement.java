package MonthlyStatement;
import java.io.Serializable;
import java.util.*;

import Accounts.CreditCard;
import Hardware.*;
public class CreditCardMonthlyStatement implements Serializable {
	/*The Checking Account Monthly statement currently has a StringBuilder for printing to GUI's, an ArrayList of Fees,
	   a beginning and ending balance a monthandYear field and an associated checking account*/
		private StringBuilder sb;
		private double endBalance, begBalance;
		private String monthAndYear;
		private CreditCard accnt;

	/* lines 17 thru 50 are the getters and setter*/
		
		public void setBegBalance(double begBal) {
			this.begBalance = begBal;
		}
		public double getBegBalance() {
			return this.begBalance;
		}
		public double getEndBalance() {
			return endBalance;
		}
		public void setEndBalance(double endBalance) {
			this.endBalance = endBalance;
		}
		
		public void setAccount(CreditCard cc) {
			this.accnt = cc;
		}
		public CreditCard getAccount() {
			return this.accnt;
		}
		public void setMonthAndYear(String monthAndYear) {
			this.monthAndYear = monthAndYear;
		}
		public String getMonthAndYear() {
			return this.monthAndYear;
		}
		
		/* this function is the no arg constructor. */
		public CreditCardMonthlyStatement() {  
			this.begBalance = 0;
			this.endBalance = 0;
			this.monthAndYear = "January 2018";
			Bank b1 = new Bank();
			this.accnt = new CreditCard(b1);
			this.sb = new StringBuilder();
			
		}
		/* This function is the parametered constructor. It takes in the date and the account.*/
		public CreditCardMonthlyStatement(String monthAndYear, CreditCard cc) { 
			this.accnt = cc; 
			this.sb = new StringBuilder();
			this.calcBegBal(cc);
			this.endBalance = cc.getBalance();
			this.monthAndYear = monthAndYear;
			
			 
			
		}
		
		public void calcBegBal(CreditCard cc) {
			this.begBalance = this.accnt.getBalance();

			for(Transaction t : cc.getTransactions()) {
				if(t.getType()== "Purchase") {
					this.begBalance = this.begBalance - t.getAmmount();
					}
				if(t.getType() == "Payment") {
					this.begBalance = cc.getBalance() + cc.getMinMonthlyPayment();
				}
			}
			for(Fee f : cc.getFees()) {
				this.begBalance = this.begBalance - f.getAmount();
			}
			
		}
		
			
		
		
		
		
		
	  /* this function is useful if we only want to print fees*/  
		public void printFees() {
		
		sb.append("Fees for: "+monthAndYear+"\n");
		for(Fee f: this.accnt.getFees()) {
	    sb.append(f.getAmount()+" "+f.getType()+"\n");	
	    }
		System.out.print(sb);
		sb.setLength(0);// clears the StringBuilder to avoid printing unwanted stuff

		}
	/* this function is useful if we only want to print transactions*/  	
		public void printTransactions() {
			sb.append("Transaction for: " +monthAndYear+"\n");
			for(Transaction t : this.accnt.getTransactions()) {
				sb.append(t.getAmmount()+" "+t.getType()+"\n");
				
				
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
			sb.append("MONTHLY CREDIT CARD STATEMENT\n");
			sb.append("\nAccount number: "+ this.accnt.getAccountNumber() + "\n");
			sb.append("\nInterest rate: "+this.accnt.getInterestRate() + "\n");
			sb.append("\nLimit: "+this.accnt.getLimit() + "\n");
			sb.append("\nMinimum monthy Payment: "+this.accnt.getMinMonthlyPayment() + "\n");
			sb.append("\nStarting Balance for " +monthAndYear+": "+begBalance+ "\n");
			sb.append("\nEnding Balance for "+monthAndYear+": "+endBalance+"\n");
			sb.append("\nFees for "+monthAndYear+":\n");
			for(Fee f: this.accnt.getFees()) {
		    sb.append(  "\n"+ f.getAmount()+" "+f.getType() +"\n");	
		    
		    }
			sb.append("\nTransaction for " +monthAndYear+":\n");
			for(Transaction t : this.accnt.getTransactions()) {
				sb.append( "\n"+ t.getAmmount()+" "+t.getType()+"\n");
				}
			System.out.print(sb);
			sb.setLength(0);
			/*if(this.accnt instanceof SavingsAccount) {
				SavingsAccount sa = (SavingsAccount)this.accnt;
				sb.append("Interest gained for: "+monthAndYear+"\n");
				sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
				}*/
			
		}
		

}

/*package Accounts;

import java.io.Serializable;
import java.util.*;
import Accounts.*;
import Hardware.*;
public class CheckingAccountMonthlyStatement  implements Serializable{
/*/

