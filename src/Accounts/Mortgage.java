package Accounts;

import java.io.Serializable;
import java.util.ArrayList;

import Hardware.Bank;
import MonthlyStatement.MortgageMonthlyStatement;

public class Mortgage extends BankAccount  implements Serializable{
	
	//Fields
	private double originialAmmount;
	private double principal;
	private double interestRate;
	private double monthlyPayment;
	private int term;
	private CheckingAccount paymentAccount;
	private int month;
	private ArrayList<MortgageMonthlyStatement> monthlyStatements;
	
	//Constructors
	public Mortgage(Bank bank) {
		
		super(bank);
		setOriginialAmmount(0);
		setPrincipal(0);
		setInterestRate(0);
		setRemainingBalance(0);
		setMonthlyPayment(0);
		setTerm(30);
		month = 1;
		paymentAccount = new CheckingAccount(bank);
	}
	public Mortgage(Bank bank, double oA, double p, double iR, CheckingAccount cA) {
		super(bank);
		bank.getBanksBankAccount().setBalance(bank.getBanksBankAccount().getBalance() - oA);
		setOriginialAmmount(oA);
		setPrincipal(p);
		setInterestRate(iR);
		setTerm(30);
		paymentAccount = cA;
		month = 1;
		setMonthlyPayment();
		cA.setDirectDeposit(monthlyPayment); //Direct deposit to be set for monthly payment

	}
	
	//Methods
	public void addMonthlyStatement(MortgageMonthlyStatement mS){
		monthlyStatements.add(mS);
	}
	public void setMonthlyStatements(ArrayList<MortgageMonthlyStatement> mS) {
		this.monthlyStatements = mS;
	}
	public ArrayList<MortgageMonthlyStatement> getMonthlyStatements() {
		return this.monthlyStatements;
	}
	public double getOriginialAmmount() {
		return originialAmmount;
	}
	public void setOriginialAmmount(double originialAmmount) {
		this.originialAmmount = originialAmmount;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getRemainingBalance() {
		return balance;
	}
	public void setRemainingBalance(double remainingBalance) {
		this.balance = remainingBalance;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public CheckingAccount getPaymentAccount() {
		return paymentAccount;
	}
	public void setPaymentAccount(CheckingAccount paymentAccount) {
		this.paymentAccount = paymentAccount;
	}
	public void setMonthlyPayment() {
		double c = (interestRate/100)/12;
		double h = 1+c;
		monthlyPayment = originialAmmount*(c*(Math.pow(h,360)))/(Math.pow(h, 359));
	}
	public void monthlyPayment() {// monthly function , add to transactions
		paymentAccount.withdraw(monthlyPayment);
		double c = (interestRate/100)/12;
		double h = 1+c;
		balance = originialAmmount*(((Math.pow(h,360)) - (Math.pow(h, month)))/(Math.pow(h, 360)- 1));
		principal = originialAmmount - balance;
		month++;	
		super.holdingBank.getBanksBankAccount().setBalance(super.holdingBank.getBanksBankAccount().getBalance() + monthlyPayment);

	}
}
