package People;

import Hardware.Bank;
import Hardware.Date;
import Hardware.UserLogin;
//objects implemented holdingBank
public class Teller extends Employee{
	

	public Teller(Bank holdingBank, String firstName, String lastName, String SS, String address, int zipcode,
			Date birthday, long phoneNum, UserLogin userLogin) {
		super(holdingBank, firstName, lastName, SS, address, zipcode, birthday, phoneNum, userLogin);
		// TODO Auto-generated constructor stub
	}
	//Fields
	private double hourlyPay;
	private int monthlyHours;
	private double monthlyPayCheck;
	
	//Constructors
	/*public Teller() {
		hourlyPay = -1;
		monthlyHours = -1;
	}
	public Teller(double hP, int mH) {
		hourlyPay = hP;
		monthlyHours = mH;
	}*/
	
	
	
	//Methods
	public double getHourlyPay() {
		return hourlyPay;
	}
	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	public int getMonthlyHours() {
		return monthlyHours;
	}
	public void setMonthlyHours(int monthlyHours) {
		this.monthlyHours = monthlyHours;
	}
	public void setMonthlyPayCheck() {
		monthlyPayCheck = hourlyPay*monthlyHours;
	}
	public double getMonthlyPayCheck() {
		return monthlyPayCheck;
	}
	public void setMonthlyPayCheck(double monthlyPayCheck) {
		this.monthlyPayCheck = monthlyPayCheck;
	}
	
	
	
	
	
	
}
