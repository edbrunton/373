package Hardware;

import java.io.Serializable;

import Hardware.Date;
// fee is the parent class
public class  Fee implements Serializable {
	private Date date;
	private String type;
	private double amount;
	
	public Fee() {
		this.type = "default";
		this.amount = 0; 
		this.setDate(new Date());
		}
	
	public Fee(Date feeDate, String feeType, double amnt) {
		this.setDate(feeDate);
		this.setAmount(amnt);
		this.setType(feeType);
		
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public void setAmount(double amnt) {
		this.amount = amnt;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void addToMonthlyStatement() {
		//TODO Ryan
	}
}
