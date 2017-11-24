package People;

import java.io.Serializable;

import Hardware.Bank;
import Hardware.Date;
import Hardware.UserLogin;

public class Banker extends Person  implements Serializable{

public Banker(Bank holdingBank, String firstName, String lastName, String SS, String add, int zC, Date bD, long pN,
			UserLogin userLogin) {
		super(holdingBank, firstName, lastName, SS, add, zC, bD, pN, userLogin);
		// TODO Ryan Auto-generated constructor stub
	}

//Fields
private double monthlySalary;

//Constructors
//These constructors will cause serious issues
/*public Banker() {
	monthlySalary = -1;
}
public Banker(double mS) {
	monthlySalary = mS;
}*/






//Methods
public double getMonthlySalary() {
	return monthlySalary;
}

public void setMonthlySalary(double monthlySalary) {
	this.monthlySalary = monthlySalary;
}
}
