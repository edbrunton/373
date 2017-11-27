
package MonthlyStatement;
// need to replace monthAndYear with Bank Date
import java.io.Serializable;
import java.util.*;
import Accounts.*;
import Hardware.*;
import Hardware.Date;
public class CheckingAccountMonthlyStatement  implements Serializable{
/*The Checking Account Monthly statement currently has a StringBuilder for printing to GUI's, an ArrayList of Fees,
   a beginning and ending balance a monthandYear field and an associated checking account*/
	private StringBuilder sb;
	//private ArrayList<Fee> fees;
	private double begBalance, endBalance;
	private Date stateMentDate;// needs to be a date
	private CheckingAccount accnt;

/* lines 17 thru 50 are the getters and setter*/
	public void setBegBalance(double begBal) {
		this.begBalance = begBal;
	}
	public double getBegBalance() {
		return this.begBalance;
	}
	
/*	public void setFees(ArrayList<Fee> fees) {
		this.fees = fees;
	}*/
	/*public ArrayList<Fee> getFees(){
		return this.fees;
	}*/
	
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
	public void setStatementDate(Date stateMentDate) {
		this.stateMentDate = stateMentDate;
	}
	public Date getStateMentDate() {
		return this.stateMentDate;
	}
	
	/* this function is the no arg constructor. */
	public CheckingAccountMonthlyStatement() {  
		this.begBalance = 0;
		this.endBalance = 0;
		this.stateMentDate = new Date();
		Bank b1 = new Bank();
		this.accnt = new CheckingAccount(b1);
	//	this.fees = new ArrayList<Fee>();
		this.sb = new StringBuilder();
		
	}
	/* This function is the parametered constructor. It takes in the date and the account.*/
	public CheckingAccountMonthlyStatement( CheckingAccount ca) { 
		this.accnt = ca; 
		this.sb = new StringBuilder();
	//	this.fees = new ArrayList<Fee>();
		this.calcBegBal(ca);
		this.endBalance = ca.getBalance();
		this.stateMentDate = ca.getHoldingBank().getDate();
		
		 
		
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
			for(Fee f : ca.getFees()) {
				this.begBalance = this.begBalance + f.getAmount();
			}
		}
		
	
	
/*this function adds a fee to the fee arrayList and updates the ending balance accordingly*/	
	/*public void addFee(Fee newFee) {
		this.fees.add(newFee);
		this.endBalance = this.endBalance - newFee.getAmount();
		
	}*/
	
	
  /* this function is useful if we only want to print fees*/  
	public StringBuilder printFees() {
	
		sb.setLength(0);
		sb.append("Fees for: "+stateMentDate+"\n");
	for(Fee f: this.accnt.getFees()) {
    sb.append(f.getAmount()+" "+f.getType()+"\n");	
    }
	System.out.print(sb);
	return this.sb;
	}
/* this function is useful if we only want to print transactions*/  	
	public StringBuilder printTransactions() {
		sb.setLength(0);
		sb.append("Transaction for: " +stateMentDate+"\n");
		for(Transaction t : this.accnt.getTransactions()) {
			sb.append(t+"\n");
			
			
		}
		System.out.print(sb);
		return this.sb;

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
	public StringBuilder printBegEndBal() {
		sb.setLength(0);
		sb.append("Starting Balance for " +stateMentDate+": "+begBalance+ "\n");
		sb.append("Ending Balance for "+stateMentDate+": "+endBalance+"\n");
		System.out.print(sb);
		return this.sb;

	}
	
	public StringBuilder printMonthlyStatement() { // prints start , end balance, transactions, fees, and interest gained if savings account
		sb.setLength(0);
		sb.append("<html><p>MONTHLY CHECKING ACCOUNT STATEMENT</p>");
		sb.append("<p>Account number: "+ this.accnt.getAccountNumber() + "</p>");
		sb.append("<p>Direct deopsit amount: "+this.accnt.getDirectDeposit());
		sb.append("<html>Starting Balance for " +stateMentDate+": "+begBalance+ "</p>");
		sb.append("<p>Ending Balance for "+stateMentDate+": "+endBalance+"</p>");
		sb.append("<p>Fees for: "+stateMentDate+"</p>");
		for(Fee f: accnt.getFees()) {
	    sb.append("<p>"+f.getAmount()+" "+f.getType()+"</p>");	
	    
	    }
		sb.append("<p>Transaction for: " +stateMentDate+"</p>");
		for(Transaction t : this.accnt.getTransactions()) {
			sb.append("<p>"+t.getAmmount()+" "+t.getType()+"</p>");
			}
		System.out.print(sb);
		/*if(this.accnt instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount)this.accnt;
			sb.append("Interest gained for: "+monthAndYear+"\n");
			sb.append(sa.getBalance() * (sa.getInterestRate()/1200));
			}*/
		return this.sb;
	
	}
}
