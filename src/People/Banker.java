package People;

import java.io.Serializable;

public class Banker extends Person  implements Serializable{

//Fields
private double monthlySalary;

//Constructors
public Banker() {
	monthlySalary = -1;
}
public Banker(double mS) {
	monthlySalary = mS;
}






//Methods
public double getMonthlySalary() {
	return monthlySalary;
}

public void setMonthlySalary(double monthlySalary) {
	this.monthlySalary = monthlySalary;
}
}
