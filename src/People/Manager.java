package People;

import java.io.Serializable;

import Hardware.Bank;
import Hardware.Date;
import Hardware.UserLogin;
// Objects used null ,  Bank
public class Manager extends Employee  implements Serializable{
	

	public Manager(Bank holdingBank, String firstName, String lastName, String SS, String address, int zipcode,
			Date birthday, long phoneNum, UserLogin userLogin) {
		super(holdingBank, firstName, lastName, SS, address, zipcode, birthday, phoneNum, userLogin);
		// TODO Auto-generated constructor stub
	}
	//Fields
	private double monthlySalary;
	
	//Constructors
	/*public Manager() {
		setMonthlySalary(-1);
	}
	public Manager(double mS) {
		setMonthlySalary(mS);
	}*/
	
	//Methods
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	
	
}
