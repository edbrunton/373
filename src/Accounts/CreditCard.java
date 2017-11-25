package Accounts;

import java.io.Serializable;
import java.util.ArrayList;

import Hardware.Bank;
import Hardware.Fee;
import Hardware.Transaction;

public class CreditCard extends BankAccount  implements Serializable{

	//Fields
	private double interestRate;
	private double limit;
	private double minMonthlyPayment;
	private CheckingAccount C1;
	protected ArrayList<CreditCardMonthlyStatement> monthlyStatements;
	//Constructors
	public CreditCard(Bank bank) {
		super(bank);
		interestRate = 0;
		balance = 0;
		limit = 0;
		C1 = new CheckingAccount(bank);
	}
	public CreditCard(Bank bank, double iR, double b, double l, CheckingAccount CA) {
		super(bank);
		interestRate = iR;
		balance = b;
		limit = l;
		C1 = CA;
	}	
	//Methods
	public void addMonthlyStatement(CreditCardMonthlyStatement mS){
		monthlyStatements.add(mS);
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getLimit() {
		return limit;
	}
	public void setMonthlyStatements(ArrayList<CreditCardMonthlyStatement> mS) {
		this.monthlyStatements = mS;
	}
	public ArrayList<CreditCardMonthlyStatement> getMonthlyStatements() {
		return this.monthlyStatements;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
/*	created getter and setter for minMonthlyPayment
*/	public void setMinMonthlyPayment(double mmp) {
		this.minMonthlyPayment = mmp;
	}
	public double getMinMonthlyPayment() {
		return this.minMonthlyPayment;
	}
	public void purchase(double spent) {
		balance = balance + spent;
		super.holdingBank.getBanksBankAccount().setBalance(super.holdingBank.getBanksBankAccount().getBalance() - spent);
		Transaction t1 = new Transaction(spent, "Purchase");// added transaction
		this.transactions.add(t1);                          // of Purchase type 
	}
	/* overides the parent addFee method since the balance goes up here */
	public void addFee(Fee newFee) {
		this.fees.add(newFee);
		this.balance = this.balance + newFee.getAmount();
	}
	public void monthlyPayment() {// we should allow for more than min payment.
		minMonthlyPayment = (balance*interestRate) + (0.01*balance);
		balance = balance - minMonthlyPayment;
		C1.withdraw(minMonthlyPayment);
		super.holdingBank.getBanksBankAccount().setBalance(super.holdingBank.getBanksBankAccount().getBalance() + minMonthlyPayment);

	}
	
	
	
	
}
