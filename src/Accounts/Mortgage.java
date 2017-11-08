package Accounts;

import java.io.Serializable;

public class Mortgage extends BankAccount  implements Serializable{
	
	//Fields
	private double originialAmmount;
	private double principal;
	private double interestRate;
	private double remainingBalance;
	private double monthlyPayment;
	private int term;
	
	//Constructors
	public Mortgage() {
		setOriginialAmmount(0);
		setPrincipal(0);
		setInterestRate(0);
		setRemainingBalance(0);
		setMonthlyPayment(0);
		setTerm(0);
	}
	public Mortgage(double oA, double p, double iR, double rB, double mP, int t) {
		setOriginialAmmount(oA);
		setPrincipal(p);
		setInterestRate(iR);
		setRemainingBalance(rB);
		setMonthlyPayment(mP);//TODO Ryan. Needs to be calculated, not just set
		setTerm(t);
	}
	
	//Methods
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
		return remainingBalance;
	}
	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
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
	
	
	
	
}
