//objects used Mortgage
package MonthlyStatement;
// need to replace monthAndYear with Bank Date
import java.io.Serializable;
import java.util.*;
import Accounts.*;
import Hardware.*;
import Hardware.Date;
public class MortgageMonthlyStatement  implements Serializable{
/*The Checking Account Monthly statement currently has a StringBuilder for printing to GUI's, an ArrayList of Fees,
   a beginning and ending balance a monthandYear field and an associated checking account*/
	private StringBuilder sb;
	//private ArrayList<Fee> fees;
	private double begBalance, endBalance;
	private Date stateMentDate;// needs to be a date
	private Mortgage accnt;

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
	
	public void setAccount(Mortgage m) {
		this.accnt = m;
	}
	public BankAccount getAccount() {
		return this.accnt;
	}
	public void setStatementDate(Date stateMentDate) {
		this.stateMentDate = stateMentDate;
	}
	public Date getStateMentDate() {
		return this.stateMentDate;
	}
	
	/* this function is the no arg constructor. */
	public MortgageMonthlyStatement() {  
		this.begBalance = 0;
		this.endBalance = 0;
		this.stateMentDate = new Date();
		Bank b1 = new Bank();
		this.accnt = new Mortgage(b1);
	//	this.fees = new ArrayList<Fee>();
		this.sb = new StringBuilder();
		
	}
	/* This function is the parametered constructor. It takes in the date and the account.*/
	public MortgageMonthlyStatement( Mortgage m) { 
		this.accnt = m; 
		this.sb = new StringBuilder();
	//	this.fees = new ArrayList<Fee>();
		this.calcBegBal(m);
		this.endBalance = m.getBalance();
		this.stateMentDate = m.getHoldingBank().getDate();
		
		 
		
	}
	/*this function calculates beginning balance by negating transactions which have directly modified balance already(used in constructor)*/	
	public void calcBegBal(Mortgage m) { 
		this.begBalance = accnt.getBalance();
			for(Transaction t : m.getTransactions()){
				if(t.getType()== "Payment") {
					this.begBalance = this.begBalance - t.getAmmount();
				}
			for(Fee f : m.getFees()) {
				this.begBalance = this.begBalance + f.getAmount();
			}
		}
			}
		
	
	
/*this function adds a fee to the fee arrayList and updates the ending balance accordingly*/	
	/*public void addFee(Fee newFee) {
		this.fees.add(newFee);
		this.endBalance = this.endBalance - newFee.getAmount();
		
	}*/
	
	
  /* this function is useful if we only want to print fees*/  
	public StringBuilder printFees() {
		sb.setLength(0);// clears the StringBuilder to avoid printing unwanted stuff

	sb.append("<html>Fees for: "+stateMentDate+" </p>");
	for(Fee f: this.accnt.getFees()) {
    sb.append(f.getAmount()+" "+f.getType()+" </p>");	
    }
	System.out.print(sb);
	return this.sb;
	}
/* this function is useful if we only want to print transactions*/  	
	public StringBuilder printTransactions() {
		sb.setLength(0);//Clears the StringBuilder to avoid printing unwanted stuffs

		sb.append("<html>Transaction for: " +stateMentDate+" </p>");
		for(Transaction t : this.accnt.getTransactions()) {
			sb.append(t.getAmmount()+" "+t.getType()+" </p>");
			
			
		}
		System.out.print(sb);
		return this.sb;
	}
	
/*	public void printInterest() {
		if(this.accnt instanceof SavingsAccount ) {
			SavingsAccount sa = (SavingsAccount)this.accnt;
			sb.append("Interest gained for: "+monthAndYear+" </p>");
			sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
			System.out.print(sb);
			sb.setLength(0); // Clears StringBuilder to avoid printing unwanted stuff
			
			
			
		}
	}*/
	

        		
        
 /* this function is useful if we only want to print beginning and ending balances*/        
	public StringBuilder printBegEndBal() {
		sb.setLength(0);
		sb.append("<html>Starting Balance for " +stateMentDate+": "+begBalance+ " </p>");
		sb.append("<p>Ending Balance for "+stateMentDate+": "+endBalance+" </p>");
		System.out.print(sb);
		return this.sb;
		
	}
	
	public StringBuilder printMonthlyStatement() { // prints start , end balance, transactions, fees, and interest gained if savings account
		sb.setLength(0);
		sb.append("<html>MONTHLY MORTGAGE STATEMENT</p>");
		sb.append("<p>Account number: "+ this.accnt.getAccountNumber() + "</p>");
		sb.append("<p>Principal: "+this.accnt.getPrincipal() + "</p>");
		sb.append("<p>Interest: "+this.accnt.getInterestRate() + "</p>");
		sb.append("<p>Term: "+this.accnt.getTerm() + "</p>");
		sb.append("<p>Monthy Payment: "+this.accnt.getMonthlyPayment() + "</p>");
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
