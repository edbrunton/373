package Hardware;

import java.io.Serializable;

public class MonthlyButton implements Serializable{
	//Fields
	private Date date;
	//tbh, this was a very poorly made class
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
