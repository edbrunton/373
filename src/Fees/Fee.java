package Fees;

import java.io.Serializable;

import Hardware.Date;
// fee is the parent class
public abstract class  Fee implements Serializable {
	private Date date;
	
	public Fee() {
		
		this.setDate(new Date());
	}
	
	public Fee(Date feeDate) {
		this.setDate(feeDate);
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void addToMonthlyStatement() {
		//TODO Ryan
	}
}
