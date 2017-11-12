package Fees;

import java.io.Serializable;

import Hardware.Date;

public class TransferFee extends Fee implements Serializable{
	private double Amount;

	public TransferFee() {
		super.setDate(new Date());
		this.setAmount(0);
	}

	public TransferFee(Date feeDate, double amnt) {
		super.setDate(feeDate);
		this.setAmount(amnt);
	}


	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}
}
