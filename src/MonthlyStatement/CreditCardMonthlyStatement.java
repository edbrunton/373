package MonthlyStatement;
import java.io.Serializable;
import java.util.*;

import Accounts.CreditCard;
import Hardware.*;
import Hardware.Date;
public class CreditCardMonthlyStatement implements Serializable {
	/*The Checking Account Monthly statement currently has a StringBuilder for printing to GUI's, an ArrayList of Fees,
	   a beginning and ending balance a stateMentDate field and an associated checking account*/
		private StringBuilder sb;
		private double endBalance, begBalance;
		private Date stateMentDate;
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
		public void setstateMentDate(Date stateMentDate) {
			this.stateMentDate = stateMentDate;
		}
		public Date getstateMentDate() {
			return this.stateMentDate;
		}
		
		/* this function is the no arg constructor. */
		public CreditCardMonthlyStatement() {  
			this.begBalance = 0;
			this.endBalance = 0;
			this.stateMentDate = new Date();
			Bank b1 = new Bank();
			this.accnt = new CreditCard(b1);
			this.sb = new StringBuilder();
			
		}
		/* This function is the parametered constructor. It takes in the date and the account.*/
		public CreditCardMonthlyStatement( CreditCard cc) { 
			this.accnt = cc; 
			this.sb = new StringBuilder();
			this.calcBegBal(cc);
			this.endBalance = cc.getBalance();
			this.stateMentDate = cc.getHoldingBank().getDate();
			
			
			 
			
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
		public StringBuilder printFees() {
			sb.setLength(0);// clears the StringBuilder to avoid printing unwanted stuff
			sb.append("<html>Fees for: "+stateMentDate+"</p>");
				for(Fee f: this.accnt.getFees()) {
					sb.append("<p>"+f.getAmount()+" "+f.getType()+"</p>");	
				}
			System.out.print(sb);
			return this.sb;

		}
	/* this function is useful if we only want to print transactions*/  	
		public StringBuilder printTransactions() {
			sb.setLength(0);//Clears the StringBuilder to avoid printing unwanted stuffs

			sb.append("<html>Transaction for: " +stateMentDate+"</p>");
			for(Transaction t : this.accnt.getTransactions()) {
				sb.append("<p>"+t.getAmmount()+" "+t.getType()+"</p>");
				
				
			}
			System.out.print(sb);
			return this.sb;
		}
		
	/*	public void printInterest() {
			if(this.accnt instanceof SavingsAccount ) {
				SavingsAccount sa = (SavingsAccount)this.accnt;
				sb.append("Interest gained for: "+stateMentDate+"</p>");
				sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
				System.out.print(sb);
				sb.setLength(0); // Clears StringBuilder to avoid printing unwanted stuff
				
				
				
			}
		}*/
		

	        		
	        
	 /* this function is useful if we only want to print beginning and ending balances*/        
		public StringBuilder printBegEndBal() {
			sb.setLength(0);
			sb.append("<p>Starting Balance for " +stateMentDate+": "+begBalance+ "</p>");
			sb.append("<p>Ending Balance for "+stateMentDate+": "+endBalance+"</p>");
			System.out.print(sb);
			return this.sb;
		}
		
		public StringBuilder printMonthlyStatement() { // prints start , end balance, transactions, fees, and interest gained if savings account
			sb.setLength(0);
			sb.append("<html>MONTHLY CREDIT CARD STATEMENT</p>");
			sb.append("<p>Account number: "+ this.accnt.getAccountNumber() + "</p>");
			sb.append("<p>Interest rate: "+this.accnt.getInterestRate() + "</p>");
			sb.append("<p>Limit: "+this.accnt.getLimit() + "</p>");
			sb.append("<p>Minimum monthy Payment: "+this.accnt.getMinMonthlyPayment() + "</p>");
			sb.append("<p>Starting Balance for " +stateMentDate+": "+begBalance+ "</p>");
			sb.append("<p>Ending Balance for "+stateMentDate+": "+endBalance+"</p>");
			sb.append("<p>Fees for "+stateMentDate+":</p>");
			for(Fee f: this.accnt.getFees()) {
		    sb.append(  "<p>"+ f.getAmount()+" "+f.getType() +"</p>");	
		    
		    }
			sb.append("<p>Transaction for " +stateMentDate+":</p>");
			for(Transaction t : this.accnt.getTransactions()) {
				sb.append( "<p>"+ t.getAmmount()+" "+t.getType()+"</p>");
				}
			System.out.print(sb);
			/*if(this.accnt instanceof SavingsAccount) {
				SavingsAccount sa = (SavingsAccount)this.accnt;
				sb.append("Interest gained for: "+stateMentDate+"</p>");
				sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
				}*/
			return this.sb;
		}
		

}

/*package Accounts;

import java.io.Serializable;
import java.util.*;
import Accounts.*;
import Hardware.*;
public class CheckingAccountMonthlyStatement  implements Serializable{
/*/

