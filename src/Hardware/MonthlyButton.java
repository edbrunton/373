package Hardware;

import java.io.Serializable;

public class MonthlyButton implements Serializable{
	//Fields
	private Date date;
	
	//Constructor
	public MonthlyButton() {
		date = new Date();	
	}
	public MonthlyButton(Date d) {
		date = d;
	}
	
	
	
	
	
	//Methods
	public void pushMonthlyButton() {
		//Every Monthly Function
		
		
		
		
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
