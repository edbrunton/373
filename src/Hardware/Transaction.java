package Hardware;

import java.io.Serializable;

public class Transaction  implements Serializable{
	
	//Fields
	private double ammount;
	private String type;
	
	//Constructors
	public Transaction() {
		ammount = 0;
		type = "Default";
	}
	public Transaction(double a, String t) {
		ammount = a;
		type = t;
	}
	
	
	
	//Methods
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
}
