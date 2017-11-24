package Fees;

import java.io.Serializable;

import Hardware.Date;

public class LateFee extends Fee  implements Serializable{
	private double amount;
	
	public LateFee() {
		
		super.setDate(new Date());
		this.setAmount(0);
		
	}
	public LateFee(Date feeDate, double amnt) {
		super.setDate(feeDate);
		this.setAmount(amnt);
		
	}
	public double getAmount() {
		
		return amount;	
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
