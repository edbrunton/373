package People;

import java.io.Serializable;

public class Manager extends Employee  implements Serializable{
	
	//Fields
	private double monthlySalary;
	
	//Constructors
	public Manager() {
		setMonthlySalary(-1);
	}
	public Manager(double mS) {
		setMonthlySalary(mS);
	}
	
	//Methods
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	
	
}
